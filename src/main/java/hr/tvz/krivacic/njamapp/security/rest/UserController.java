package hr.tvz.krivacic.njamapp.security.rest;

import hr.tvz.krivacic.njamapp.security.domain.RefreshToken;
import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import hr.tvz.krivacic.njamapp.security.dto.RefreshTokenRequestDTO;
import hr.tvz.krivacic.njamapp.security.repository.UserRepository;
import hr.tvz.krivacic.njamapp.security.service.JwtService;
import hr.tvz.krivacic.njamapp.security.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.codehaus.janino.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/korisnik")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @GetMapping("/me")
    public UserInfo getCurrentUser() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    @GetMapping("/by-token")
    public UserInfo getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "").trim();

        String username = jwtService.extractUsername(token);
        return userRepository.findByUsername(username);
    }
}
