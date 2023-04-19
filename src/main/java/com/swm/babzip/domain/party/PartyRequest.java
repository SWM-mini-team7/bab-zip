package com.swm.babzip.domain.party;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartyRequest {

    private String title;
    private String menu;
    private Integer maxMemberCount;
    private String description;
    private LocalDateTime meetingTime;
    public Party toEntity() {
        return new Party(title, menu, maxMemberCount, description, meetingTime);
    }
}
