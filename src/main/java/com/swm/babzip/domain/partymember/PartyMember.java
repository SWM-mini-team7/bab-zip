package com.swm.babzip.domain.partymember;

import com.swm.babzip.domain.member.Member;
import com.swm.babzip.domain.party.Party;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PartyMember {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Party party;

    @Column(nullable = false)
    private boolean isReader;

    public PartyMember(Member member, Party party, boolean isReader) {
        this.member = member;
        this.party = party;
        this.isReader = isReader;
    }
}
