package hr.tvz.krivacic.njamapp.security.repository;

import hr.tvz.krivacic.njamapp.security.domain.RefreshToken;
import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
    @Transactional
    void deleteByUserInfo(UserInfo user);
}
