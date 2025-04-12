package hr.tvz.krivacic.njamapp.repository;


import hr.tvz.krivacic.njamapp.model.Kupac;
import hr.tvz.krivacic.njamapp.model.Restoran;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Repository
public class MockKupacRepository implements KupacRepository {

    private static List<Kupac> kupci = new ArrayList<>(Arrays.asList(
            new Kupac(1L, "Ante", "Krivacic", "savska22", "385 999 100"),
            new Kupac(2L, "Ivan", "Ivanovic", "zagrebacka22", "385 999 101")

    ));
    @Override
    public List<Kupac> findAll() {
        return new ArrayList<>(kupci);
    }

    @Override
    public Optional<Kupac> findKupacByID(Long id) {
        return kupci.stream()
                .filter(kupac -> kupac.getID().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Kupac> spremiKupca(Kupac kupac) {
        return kupci.add(kupac) ? Optional.of(kupac) : Optional.empty();
    }

    @Override
    public void izbrisiKupca(Long id) {
        kupci = kupci.stream()
                .filter(kupac -> !kupac.getID().equals(id))
                .toList();
    }
}
