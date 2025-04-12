package hr.tvz.krivacic.njamapp.controller;

import hr.tvz.krivacic.njamapp.dto.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranCommand;
import hr.tvz.krivacic.njamapp.service.RestoranServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restoran")
public class RestoranController {
    private static final Logger logger = LoggerFactory.getLogger(RestoranController.class);
    private final RestoranServiceImpl restoranServiceImpl;

    public RestoranController(RestoranServiceImpl restoranServiceImpl) {
        this.restoranServiceImpl = restoranServiceImpl;
    }

    @GetMapping()
    public List<RestoranDTO> getAllRestorani(){
        return restoranServiceImpl.findAll();
    }

    @GetMapping(params = "id")
    public RestoranDTO getRestoranById(@RequestParam final Long id){
        return restoranServiceImpl.findRestoranByID(id);
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

}

