package hr.tvz.krivacic.njamapp.controller;

import hr.tvz.krivacic.njamapp.dto.RecenzijaDTO;
import hr.tvz.krivacic.njamapp.model.RecenzijaCommand;
import hr.tvz.krivacic.njamapp.service.RecenzijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    private RecenzijaDTO postRecenzija(@RequestBody RecenzijaCommand recenzija) {
        return recenzijaService.spremi(recenzija);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteRecenzija(@PathVariable Long id) {
        recenzijaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    private ResponseEntity<RecenzijaDTO> updateRecenzija(@PathVariable Long id, @RequestBody RecenzijaCommand recenzija) {
        RecenzijaDTO updatedRecenzija = recenzijaService.update(id, recenzija);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRecenzija);
    }
}
