package com.swm.babzip.domain.party;

import com.swm.babzip.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;

    @Transactional
    public IdResponse<Long> create(PartyRequest dto) {
        Party party = partyRepository.save(dto.toEntity());
        return new IdResponse<>(party.getId());
    }

    public List<PartySummary> getAll() {
        return partyRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Party::getMeetingTime).reversed())
                .map(PartySummary::new)
                .toList();
    }
}
