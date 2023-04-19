package com.swm.babzip.config.security;

import lombok.Getter;

@Getter
public class OAuth2Request {
    private String accountId;
    private String nickname;

    public OAuth2Request(String accountId, String nickname) {
        this.accountId = accountId;
        this.nickname = nickname;
    }
}
