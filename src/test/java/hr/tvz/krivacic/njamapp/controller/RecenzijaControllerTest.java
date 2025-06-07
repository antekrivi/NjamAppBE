package hr.tvz.krivacic.njamapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.krivacic.njamapp.model.RecenzijaCommand;
import hr.tvz.krivacic.njamapp.service.RecenzijaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RecenzijaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllRecenzijeTest() throws Exception{
        mockMvc.perform(
                get("/recenzija")
                        .with(user("admin")
                                .password("password")
                                .roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$").isArray());
    }
    @Test
    void getRecenzijeByRestoranIdTest() throws Exception {
        mockMvc.perform(get("/recenzija")
                        .param("restoranId", "1")
                        .with(user("admin").roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void postRecenzijaTest() throws Exception {
        RecenzijaCommand newRecenzija = new RecenzijaCommand("Odlična usluga", "Vrlo dobro",
                5, 1L);

        String jsonRequest = objectMapper.writeValueAsString(newRecenzija);

        mockMvc.perform(post("/recenzija")
                        .with(user("admin").roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteRecenzijaTest() throws Exception {
        Long idToDelete = 1L;

        mockMvc.perform(delete("/recenzija/{id}", idToDelete)
                        .with(user("admin").roles("ADMIN")))
                .andExpect(status().isNoContent());
    }

    @Test
    void updateRecenzijaTest() throws Exception {
        postRecenzijaTest();
        Long idToUpdate = 1L;
        RecenzijaCommand updatedRecenzija = new RecenzijaCommand("Updated komentar", "Loše",
                2, 1L);

        String jsonRequest = objectMapper.writeValueAsString(updatedRecenzija);

        mockMvc.perform(put("/recenzija/{id}", idToUpdate)
                        .with(user("admin").roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}