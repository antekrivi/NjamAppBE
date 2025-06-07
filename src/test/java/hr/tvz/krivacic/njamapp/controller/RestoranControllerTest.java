package hr.tvz.krivacic.njamapp.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class RestoranControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllRestorani() throws Exception {
        mockMvc.perform(get("/restoran")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
    @Test
    void findMichelinoveRestorani() throws Exception {
        mockMvc.perform(get("/restoran/michelin")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getRestoranById() throws Exception {
        spremi();
        mockMvc.perform(get("/restoran")
                        .param("id", "1")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void getFullRestoran() throws Exception {
        mockMvc.perform(get("/restoran/full")
                        .param("id", "1")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getRestoranByIme() throws Exception {
        spremi();
        mockMvc.perform(get("/restoran")
                        .param("ime", "Restoran Test")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.imeRestorana").value("Restoran Test"));
    }

    @Test
    void getNajblizi() throws Exception {
        mockMvc.perform(get("/restoran")
                        .param("adresa", "Zagreb")
                        .param("ocjena", "4.5")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void spremi() throws Exception {
        String json = """
        {
            "imeRestorana": "Restoran Test",
            "adresa": "Ulica 1, Zagreb",
            "brojTelefona": "123-456-789",
            "email": "test@example.com",
            "radnoVrijeme": "{\\"ponedjeljak\\":\\"08:00-22:00\\",\\"utorak\\":\\"08:00-22:00\\",\\"srijeda\\":\\"08:00-22:00\\",\\"četvrtak\\":\\"08:00-22:00\\",\\"petak\\":\\"08:00-22:00\\",\\"subota\\":\\"08:00-22:00\\",\\"nedjelja\\":\\"08:00-22:00\\"}",           
            "trenutnoOtvoreno": true,
            "prosVrijemeDostave": 30,
            "prosOcjenaKupca": 4.5,
            "maxBrojNarudzbi": 20,
            "michelinZvjezdice": 1,
            "kratkiOpis": "Vrlo ukusan restoran.",
            "brojStolova": 10,
            "godinaOsnivanja": 2005
        }
    """;
        mockMvc.perform(post("/restoran/spremi")
                        .with(user("admin")
                                .password("password")
                                .roles("ADMIN"))
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.imeRestorana").value("Restoran Test"));
    }


    @Test
    void izbrisi() throws Exception {
        mockMvc.perform(delete("/restoran/1")
                        .with(user("admin").roles("ADMIN")))
                .andExpect(status().isNoContent());
    }

    @Test
    void updateRestoran() throws Exception {
        spremi();
        String updateJson = """
            {
                "imeRestorana": "AzuriraniRestoran",
                "adresa": "Nova adresa 2",
                "brojTelefona": "321-654-987",
                "email": "azurirani@example.com",
                "radnoVrijeme": "{\\"ponedjeljak\\":\\"08:00-22:00\\",\\"utorak\\":\\"08:00-22:00\\",\\"srijeda\\":\\"08:00-22:00\\",\\"četvrtak\\":\\"08:00-22:00\\",\\"petak\\":\\"08:00-22:00\\",\\"subota\\":\\"10:00-23:00\\",\\"nedjelja\\":\\"Zatvoreno\\"}",
                "trenutnoOtvoreno": true,
                "prosVrijemeDostave": 35,
                "prosOcjenaKupca": 4.8,
                "maxBrojNarudzbi": 25,
                "michelinZvjezdice": 2,
                "kratkiOpis": "Ažurirani opis restorana.",
                "brojStolova": 12,
                "godinaOsnivanja": 2010
            }
            """;
        mockMvc.perform(put("/restoran/1")
                        .with(user("admin").roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imeRestorana").value("AzuriraniRestoran"));
    }


    @Test
    void getTrenutnoOtvoreniRestorani() throws Exception {
        mockMvc.perform(get("/restoran/trenutno-otvoreni")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getNajbolji() throws Exception {
        mockMvc.perform(get("/restoran/najbolji")
                        .param("ocjena", "4.5")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getNajboljiZadnjih7Dana() throws Exception {
        mockMvc.perform(get("/restoran/najboljiZadnjih7Dana")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getNajboljiZadnjih30Dana() throws Exception {
        mockMvc.perform(get("/restoran/najboljiZadnjih30Dana")
                        .with(user("admin").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}