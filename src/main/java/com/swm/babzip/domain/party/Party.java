package com.swm.babzip.domain.party;

import com.swm.babzip.domain.partymember.PartyMember;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Party {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String menu;

    @Column(nullable = false)
    private Integer maxMemberCount;

    private Integer currentMemberCount = 1;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "party", cascade = CascadeType.ALL)
    private Set<PartyMember> members = new HashSet<>();

    @Lob
    private String description;

    @Column(nullable = false)
    private LocalDateTime meetingTime;

    public Party(String title, String menu, Integer maxMemberCount, String description, LocalDateTime meetingTime) {
        this.title = title;
        this.menu = menu;
        this.maxMemberCount = maxMemberCount;
        this.description = description;
        this.meetingTime = meetingTime;
    }

    public void participant(PartyMember member) {
        members.add(member);
        currentMemberCount++;
    }
}
