package hr.tvz.krivacic.njamapp.controller;

import hr.tvz.krivacic.njamapp.dto.KupacDTO;
import hr.tvz.krivacic.njamapp.model.Kupac;
import hr.tvz.krivacic.njamapp.model.KupacCommand;
import hr.tvz.krivacic.njamapp.service.KupacServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("kupac")
public class KupacController {
    private static final Logger logger = LoggerFactory.getLogger(KupacController.class);

    private final KupacServiceImpl kupacServiceImpl;

    public KupacController(KupacServiceImpl kupacServiceImpl) {
        this.kupacServiceImpl = kupacServiceImpl;
    }

    @GetMapping()
    public List<KupacDTO> getAllKupci(){
        return kupacServiceImpl.findAll();
    }
    @GetMapping(params = "id")
    public KupacDTO getKupacById(@RequestParam final Long id){
        return kupacServiceImpl.findKupacByID(id);
    }
    @PostMapping("/spremi")
    public ResponseEntity<KupacDTO> spremi(@Valid @RequestBody Kupac kupac){
        return kupacServiceImpl.spremiKupca(kupac)
                .map(
                        kupacDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(kupacDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(params = "id")
    public void izbrisi(@RequestParam Long id){
        kupacServiceImpl.izbrisiKupca(id);
    }

}
