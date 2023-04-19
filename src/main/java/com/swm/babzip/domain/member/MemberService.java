package com.swm.babzip.domain.member;

import com.swm.babzip.config.security.OAuth2Request;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member saveIfNone(final OAuth2Request dto) {
        return memberRepository.findByAccountId(dto.getAccountId())
                .orElseGet(() -> memberRepository.save(setUpMember(dto)));
    }

    private Member setUpMember(final OAuth2Request dto) {
        return new Member(dto.getNickname(), dto.getAccountId());
    }
}
