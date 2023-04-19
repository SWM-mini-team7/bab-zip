package com.swm.babzip.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class KakaoAttributeMapper {
    public OAuth2Request mapToDTO(Map<String, Object> attributes) {
        Map<String, Object> profile = (Map<String, Object>) attributes.get("properties");
        String accountId = attributes.get("id").toString();
        String nickname = profile.get("nickname").toString();
        return new OAuth2Request(accountId, nickname);
    }
}
