package hr.tvz.krivacic.njamapp.security.service;

import hr.tvz.krivacic.njamapp.security.domain.UserInfo;

public interface UserInfoService {
    UserInfo findByAccessToken(String accessToken);
}
