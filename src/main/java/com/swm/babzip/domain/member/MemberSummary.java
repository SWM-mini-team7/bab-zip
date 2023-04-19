package com.swm.babzip.domain.member;

import lombok.Getter;

@Getter
public class MemberSummary {

    private final Long id;
    private final String name;

    public MemberSummary(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
