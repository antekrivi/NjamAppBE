package hr.tvz.krivacic.njamapp.security.service;


import hr.tvz.krivacic.njamapp.security.domain.RefreshToken;
import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import hr.tvz.krivacic.njamapp.security.dto.RefreshTokenRequestDTO;
import hr.tvz.krivacic.njamapp.security.repository.RefreshTokenRepository;
import hr.tvz.krivacic.njamapp.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public RefreshToken createRefreshToken(String username){
        UserInfo user = userRepository.findByUsername(username);
        refreshTokenRepository.deleteByUserInfo(user);

        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userRepository.findByUsername(username))
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000)) // set expiry of refresh token to 10 minutes - you can configure it application.properties file
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }
    public void delete(RefreshToken token){
        refreshTokenRepository.delete(token);
    }
}