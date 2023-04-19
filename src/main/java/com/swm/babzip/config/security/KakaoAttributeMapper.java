package com.swm.babzip.config.security;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KakaoAttributeMapper {
    public OAuth2Request mapToDTO(Map<String, Object> attributes) {
        String accountId = attributes.get("id").toString();
        String nickname = (String) attributes.get("properties.nickname");
        return new OAuth2Request(accountId, nickname);
    }
}
