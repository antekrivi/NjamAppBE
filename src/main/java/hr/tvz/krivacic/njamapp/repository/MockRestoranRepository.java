package hr.tvz.krivacic.njamapp.repository;

import hr.tvz.krivacic.njamapp.model.Restoran;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
@Profile("dev")
@Repository
public class MockRestoranRepository implements RestoranRepository{
    private static List<Restoran> restorani = new ArrayList<>(Arrays.asList(
            new Restoran(1L, "Restoran1", "Adresa1", "123456", "rest1@gmail.com",
                    createRadnoVrijeme(), true, 30, 4.5, 10,
                    1, "Restoran s najboljom hranom u gradu"),
            new Restoran(2L, "Restoran2", "Adresa2", "654321", "rest2@gmail.com",
                    createRadnoVrijeme(), true, 25, 4.0, 15,
                    0, "Restoran s najgorom hranom u gradu")
    ));

    public MockRestoranRepository(){

    }
    @Override
    public List<Restoran> findAll() {
        return new ArrayList<>(restorani);
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        return restorani.stream()
                .filter(r -> r.getID().equals(id)).findFirst();
    }
    @Override
    public Optional<Restoran> findRestoranByIme(String ime){
        return restorani.stream()
                .filter(r -> r.getImeRestorana().equals(ime)).findFirst();
    }
    @Override
    public Optional<Restoran> spremiRestoran(Restoran restoran) {
        if(!Optional.ofNullable(restoran.getID()).isPresent()) {    //ako restoran nema ID, generiraj novi ID i spremi
            Long generatedId = generarateNewID();
            restoran.setID(generatedId);
            restorani.add(restoran);
            return Optional.of(restoran);
        }
        else{   //ako restoran ima ID
            Optional<Restoran> postojeciRestoran = restorani.stream()
                    .filter(r -> r.getID().equals(restoran.getID())).findFirst();

            if(postojeciRestoran.isEmpty()){    //ako restoran s tim ID-em ne postoji, spremi
                restorani.add(restoran);
                return Optional.of(restoran);
            }

            else{   //ako restoran s tim ID-em postoji pa updateaj
                Restoran restoranToUpdate = postojeciRestoran.get();
                restoranToUpdate.setImeRestorana(restoran.getImeRestorana());
                restoranToUpdate.setAdresa(restoran.getAdresa());
                restoranToUpdate.setBrojTelefona(restoran.getBrojTelefona());
                restoranToUpdate.setEmail(restoran.getEmail());
                restoranToUpdate.setRadnoVrijeme(restoran.getRadnoVrijeme());
                restoranToUpdate.setTrenutnoOtvoren(restoran.getTrenutnoOtvoren());
                restoranToUpdate.setProsVrijemeDostave(restoran.getProsVrijemeDostave());
                restoranToUpdate.setProsOcjenaKupca(restoran.getProsOcjenaKupca());
                restoranToUpdate.setMaxBrojNarudzbi(restoran.getMaxBrojNarudzbi());
                restoranToUpdate.setMichelinZvjezdice(restoran.getMichelinZvjezdice());
                restoranToUpdate.setKratkiOpis(restoran.getKratkiOpis());

                return Optional.of(restoranToUpdate);
            }
        }
    }
    @Override
    public void izbrisiRestoran(Long id) {
        restorani = restorani.stream()
                .filter(r -> !r.getID().equals(id))
                .toList();
    }

    private Long generarateNewID() {
        Optional<Restoran> lastPrimaryKeyValueOptional = restorani.stream()
                .max((fi1, fi2) -> fi1.getID().compareTo(fi2.getID()));

        if(lastPrimaryKeyValueOptional.isPresent()) {
            Restoran foodItem = lastPrimaryKeyValueOptional.get();
            return foodItem.getID() + 1;
        }
        else {
            return 1L;
        }
    }
    private static Map<String, String> createRadnoVrijeme() {
        Map<String, String> radnoVrijeme = new HashMap<>();
        radnoVrijeme.put("Monday", "10:00-22:00");
        radnoVrijeme.put("Tuesday", "10:00-22:00");
        radnoVrijeme.put("Wednesday", "10:00-22:00");
        radnoVrijeme.put("Thursday", "10:00-22:00");
        radnoVrijeme.put("Friday", "10:00-22:00");
        radnoVrijeme.put("Saturday", "10:00-22:00");
        radnoVrijeme.put("Sunday", "10:00-22:00");
        return radnoVrijeme;
    }
}
