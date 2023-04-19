package com.swm.babzip.domain.partymember;

import com.swm.babzip.domain.member.Member;
import com.swm.babzip.domain.member.MemberSummary;
import com.swm.babzip.domain.party.Party;
import com.swm.babzip.domain.party.PartySummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyMemberService {
    private final PartyMemberRepository partyMemberRepository;

    @Transactional
    public PartyMember create(Party party, Member member, boolean isLeader) {
        PartyMember partyMember = partyMemberRepository.save(new PartyMember(member, party, isLeader));
        party.participant(partyMember);
        return partyMember;
    }

    public List<PartySummary> findAllPartyByMember(Member member) {
        return partyMemberRepository.findAllByMember(member).stream()
                .map(PartyMember::getParty)
                .map(PartySummary::new)
                .toList();
    }

    public List<MemberSummary> findAllMemberByPartyId(Long partyId) {
        return partyMemberRepository.findAllByPartyId(partyId).stream()
                .map(PartyMember::getMember)
                .map(MemberSummary::new)
                .toList();
    }

}
