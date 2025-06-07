package hr.tvz.krivacic.njamapp.security.service;

import hr.tvz.krivacic.njamapp.security.domain.UserInfo;
import hr.tvz.krivacic.njamapp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo findByAccessToken(String accessToken) {
        return null; // This method should be implemented to find UserInfo by access token
    }
}
