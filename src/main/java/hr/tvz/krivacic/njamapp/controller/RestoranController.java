package hr.tvz.krivacic.njamapp.controller;

import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.Restoran;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;
import hr.tvz.krivacic.njamapp.repository.NajpovoljnijiRestoranRepository;
import hr.tvz.krivacic.njamapp.service.RestoranService;
import hr.tvz.krivacic.njamapp.service.RestoranServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restoran")
@CrossOrigin(origins = "http://localhost:4200")
public class RestoranController {
    private static final Logger logger = LoggerFactory.getLogger(RestoranController.class);
    private final RestoranServiceImpl restoranServiceImpl;

    public RestoranController(RestoranServiceImpl restoranServiceImpl
                               ) {
        this.restoranServiceImpl = restoranServiceImpl;
    }

    @GetMapping()
    public List<RestoranDTO> getAllRestorani(){
        return restoranServiceImpl.findAll();
    }
    @GetMapping("/michelin")
    public List<RestoranDTO> findMichelinoveRestorani(){
        return restoranServiceImpl.findMichelinoveRestorane();
    }

    @GetMapping(params = "id")
    public RestoranDTO getRestoranById(@RequestParam final Long id){
        return restoranServiceImpl.findRestoranByID(id);
    }

    @GetMapping("/full")
    public Restoran getFullRestoran(@RequestParam final Long id) {
        return restoranServiceImpl.findFullRestoranByID(id);
    }

    @GetMapping(params = "ime")
    public RestoranDTO getRestoranByIme(@RequestParam final String ime){
        return restoranServiceImpl.findRestoranByIme(ime);
    }

    @GetMapping(params = {"adresa", "ocjena"})
    public List<RestoranDTO> getNajblizi(@RequestParam final String adresa,
                                         @RequestParam final Double ocjena){
        return restoranServiceImpl.findNajblizi(adresa, ocjena);
    }
    @PostMapping("/spremi")
    public ResponseEntity<RestoranDTO> spremi(@Valid @RequestBody RestoranCommand restoranCommand){
        return restoranServiceImpl.spremiRestoran(restoranCommand)
                .map(
                        restoranDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(restoranDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{ID}")
    public void izbrisi(@PathVariable Long ID){
        restoranServiceImpl.izbrisiRestoran(ID);
    }

    @PutMapping("/{ID}")
    public ResponseEntity<RestoranDTO> updateRestoran(@PathVariable Long ID,
                                                         @RequestBody RestoranCommand restoranCommand){
        restoranCommand.setID(ID);
        Optional<RestoranDTO> restoranDTO = restoranServiceImpl.azurirajRestoran(ID, restoranCommand);

        return restoranDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("trenutno-otvoreni")
    public List<RestoranDTO> getTrenutnoOtvoreniRestorani() {
        return restoranServiceImpl.findTrenutnoOtvoreniRestorani();
    }
    @GetMapping("/najbolji")
    public List<RestoranDTO> getNajbolji(@RequestParam final Double ocjena) {
        return restoranServiceImpl.findNajbolji(ocjena);
    }

    @GetMapping("/najboljiZadnjih7Dana")
    public Optional<RestoranDTO> getNajboljiZadnjih7Dana() {
        return restoranServiceImpl.najboljiRestoranZadnjih7Dana();
    }
    @GetMapping("/najboljiZadnjih30Dana")
    public Optional<RestoranDTO> getNajboljiZadnjih30Dana() {
        return restoranServiceImpl.najboljiRestoranZadnjih30Dana();
    }

    @GetMapping("/najpovoljniji")
    public List<RestoranDTO> getNajpovoljnijiRestorani() {
        return restoranServiceImpl.findNajpovoljniji();
    }
}

