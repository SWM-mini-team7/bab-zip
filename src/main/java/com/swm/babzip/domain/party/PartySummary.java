package com.swm.babzip.domain.party;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class PartySummary {
    private final Long id;
    private final String title;
    private final String menu;
    private final Integer maxMemberCount;
    private final Integer currentMemberCount;
    private final LocalDateTime meetingTime;

    public PartySummary(Party party) {
        this.id = party.getId();
        this.title = party.getTitle();
        this.menu = party.getMenu();
        this.maxMemberCount = party.getMaxMemberCount();
        this.currentMemberCount = party.getCurrentMemberCount();
        this.meetingTime = party.getMeetingTime();
    }
}
