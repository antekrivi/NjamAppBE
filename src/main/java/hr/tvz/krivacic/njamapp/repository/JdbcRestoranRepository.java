package hr.tvz.krivacic.njamapp.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.krivacic.njamapp.model.Restoran;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcRestoranRepository implements RestoranRepository{

    private static final String SELECT_ALL = "SELECT * FROM restoran";
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public JdbcRestoranRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("restoran")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Set<Restoran> findAll() {
        return Set.copyOf(jdbc.query(SELECT_ALL, this::mapRowToRestoran));
    }

    @Override
    public List<Restoran> findMichelinoveRestorane() {
        return jdbc.query(
                SELECT_ALL + " WHERE michelin_zvijezdice > 0",
                this::mapRowToRestoran
        );
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE id = ?", this::mapRowToRestoran, id)
            );
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Restoran> findRestoranByIme(String ime) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE ime_restorana = ?", this::mapRowToRestoran, ime)
            );
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
    @Override
    public Optional<Restoran> spremiRestoran(Restoran restoran) {
        try {
            restoran.setID(spremiRestoranDetalje(restoran));
            return Optional.of(restoran);
        }catch (JsonProcessingException e1){
            e1.printStackTrace();
            return Optional.empty();
        }
        catch (DuplicateKeyException e2){
            return Optional.empty();
        }
    }
    @Override
    public void izbrisiRestoran(Long id) {
        jdbc.update("DELETE FROM restoran WHERE id = ?", id);
    }
    private Restoran mapRowToRestoran(ResultSet rs, int rowNum) throws SQLException {
        String radnoVrijemeJson = rs.getString("radno_vrijeme");
        Map<String, String> radnoVrijemeMap = new HashMap<>();
        if(radnoVrijemeJson != null && !radnoVrijemeJson.isEmpty()){
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                radnoVrijemeMap = objectMapper.readValue(radnoVrijemeJson, new TypeReference<Map<String, String>>() {});
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new Restoran(
                rs.getLong("id"),
                rs.getString("ime_restorana"),
                rs.getString("adresa"),
                rs.getString("broj_telefona"),
                rs.getString("email"),
                radnoVrijemeMap,
                rs.getBoolean("trenutno_otvoreno"),
                rs.getInt("pros_vrijeme_dostave"),
                rs.getDouble("pros_ocjena_kupca"),
                rs.getInt("max_broj_narudzbi"),
                rs.getInt("michelin_zvijezdice"),
                rs.getString("kratki_opis")
        );
    }

    private Long spremiRestoranDetalje(Restoran restoran) throws JsonProcessingException {
        Map<String, Object> values = new HashMap<>();

        values.put("ime_restorana", restoran.getImeRestorana());
        values.put("adresa", restoran.getAdresa());
        values.put("broj_telefona", restoran.getBrojTelefona());
        values.put("email", restoran.getEmail());
        ObjectMapper objectMapper = new ObjectMapper();
        String radnoVrijemeJson = objectMapper.writeValueAsString(restoran.getRadnoVrijeme());
        values.put("radno_vrijeme", radnoVrijemeJson);
        values.put("trenutno_otvoreno", restoran.getTrenutnoOtvoreno());
        values.put("pros_vrijeme_dostave", restoran.getProsVrijemeDostave());
        values.put("pros_ocjena_kupca", restoran.getProsOcjenaKupca());
        values.put("max_broj_narudzbi", restoran.getMaxBrojNarudzbi());
        values.put("michelin_zvijezdice", restoran.getMichelinZvijezdice());
        values.put("kratki_opis", restoran.getKratkiOpis());

        return inserter.executeAndReturnKey(values).longValue();
    }
}
