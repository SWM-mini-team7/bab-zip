package com.swm.babzip.domain.party;

import com.swm.babzip.domain.auth.AuthService;
import com.swm.babzip.domain.partymember.PartyMember;
import com.swm.babzip.domain.partymember.PartyMemberService;
import com.swm.babzip.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;
    private final PartyMemberService partyMemberService;
    private final AuthService authService;

    @Transactional
    public IdResponse<Long> create(PartyRequest dto) {
        Party party = partyRepository.save(dto.toEntity());
        partyMemberService.create(party, authService.getLoginUser(), true);
        return new IdResponse<>(party.getId());
    }

    public List<PartySummary> findAll() {
        return partyRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Party::getMeetingTime).reversed())
                .map(PartySummary::new)
                .toList();
    }

    public Party findById(Long id) {
        return getEntity(id);
    }
    @Transactional
    public void participate(Long id) {
        Party party = getEntity(id);
        PartyMember partyMember = partyMemberService.create(party, authService.getLoginUser(), false);
        party.participant(partyMember);
    }

    private Party getEntity(Long id) {
        return partyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
