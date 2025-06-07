package hr.tvz.krivacic.njamapp.security.rest;

import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import hr.tvz.krivacic.njamapp.security.repository.UserRepository;
import hr.tvz.krivacic.njamapp.security.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void testGetCurrentUser() throws Exception {
        // Arrange
        var username = "testuser";
        var userInfo = new UserInfo();
        userInfo.setUsername(username);

        var auth = new UsernamePasswordAuthenticationToken(username, null, List.of());
        SecurityContextHolder.getContext().setAuthentication(auth);

        Mockito.when(userRepository.findByUsername(username)).thenReturn(userInfo);

        // Act + Assert
        mockMvc.perform(get("/korisnik/me"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(username));
    }

    @Test
    void testGetUserInfoByToken() throws Exception {
        // Arrange
        var token = "fake.jwt.token";
        var username = "testuser";

        var userInfo = new UserInfo();
        userInfo.setUsername(username);

        Mockito.when(jwtService.extractUsername(token)).thenReturn(username);
        Mockito.when(userRepository.findByUsername(username)).thenReturn(userInfo);

        // Act + Assert
        mockMvc.perform(get("/korisnik/by-token")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(username));
    }
}