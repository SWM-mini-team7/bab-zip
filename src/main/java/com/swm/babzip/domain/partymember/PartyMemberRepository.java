package com.swm.babzip.domain.partymember;

import com.swm.babzip.domain.member.Member;
import com.swm.babzip.domain.party.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyMemberRepository extends JpaRepository<PartyMember, Long> {
    List<PartyMember> findAllByMemberId(Long id);
    List<PartyMember> findAllByMember(Member member);
    List<PartyMember> findAllByPartyId(Long id);
    List<PartyMember> findAllByParty(Party party);
}
