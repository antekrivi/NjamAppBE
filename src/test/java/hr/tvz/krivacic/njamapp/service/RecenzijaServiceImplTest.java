package hr.tvz.krivacic.njamapp.service;

import hr.tvz.krivacic.njamapp.model.*;
import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import hr.tvz.krivacic.njamapp.repository.*;
import hr.tvz.krivacic.njamapp.security.repository.UserRepository;
import hr.tvz.krivacic.njamapp.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class RecenzijaServiceImplTest {

    @Mock
    private RecenzijaRepository recenzijaRepository;
    @InjectMocks
    private RecenzijaServiceImpl recenzijaService;

    private UserInfo testUser;
    private Restoran testRestoran;

    @BeforeEach
    void setUp() {
        testUser = new UserInfo();
        testUser.setUsername("admin");

        testRestoran = new Restoran();
        testRestoran.setId(1L);
        testRestoran.setImeRestorana("Test Restoran");

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken("admin", null));
        SecurityContextHolder.setContext(context);
    }

    @Test
    void testFindAll() {
        Recenzija r = new Recenzija(1L, "Naslov", "Tekst recenzije", 5, testRestoran,
                LocalDateTime.now(), testUser);

        when(recenzijaRepository.findAll()).thenReturn(List.of(r));
        var result = recenzijaService.findAll();

        assertEquals(1, result.size());
        assertEquals("Naslov", result.get(0).getNaslov());
    }
}
