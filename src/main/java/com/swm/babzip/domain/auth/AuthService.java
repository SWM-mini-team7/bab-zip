package com.swm.babzip.domain.auth;

import com.swm.babzip.domain.member.Member;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public Member getLoginUser() {
        return (Member) SecurityContextHolder.getContext().getAuthentication();
    }

}
