package com.swm.babzip.domain.party;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class PartySummary {
    private Long id;
    private String title;
    private String menu;
    private Integer maxMemberCount;
    private Integer currentMemberCount;
    private LocalDateTime meetingTime;

    public PartySummary(Party party) {
        this.id = party.getId();
        this.title = party.getTitle();
        this.menu = party.getMenu();
        this.maxMemberCount = party.getMaxMemberCount();
        this.currentMemberCount = party.getCurrentMemberCount();
        this.meetingTime = party.getMeetingTime();
    }
}
