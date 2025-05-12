package hr.tvz.krivacic.njamapp.controller;

import hr.tvz.krivacic.njamapp.dto.RecenzijaDTO;
import hr.tvz.krivacic.njamapp.service.RecenzijaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recenzija")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class RecenzijaController {

    private final RecenzijaService recenzijaService;

    @GetMapping
    private List<RecenzijaDTO> getAllRecenzije() {
        return recenzijaService.findAll();
    }

    @GetMapping(params = "restoranId")
    private List<RecenzijaDTO> getRecenzijeByRestoranId(@RequestParam Long restoranId) {
        return recenzijaService.findByRestoranID(restoranId);
    }

}
