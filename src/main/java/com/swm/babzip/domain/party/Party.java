package com.swm.babzip.domain.party;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}
