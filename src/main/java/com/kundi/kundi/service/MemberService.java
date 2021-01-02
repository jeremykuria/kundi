package com.kundi.kundi.service;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.domain.enumeration.Authority;
import com.kundi.kundi.repository.MemberRepository;
import com.kundi.kundi.domain.Member;
import com.kundi.kundi.web.vm.RegistrationVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberRepository memberRepository;


    public List<Member> groupMembers(Integer id){
        return  memberRepository.findByGroupId(id);
    }

    public Member registerMember(Member member){
        log.info("Register member service");
//        Member member = new Member();
//
//        member.setfName(registrationVM.getfName());
//        member.setlName((registrationVM.getlName()));
//        member.setEmail(registrationVM.getEmail());
//        member.setActivated(false);
//        member.setAuthority(Authority.MEMBER);
//        member.setDateOfBirth((registrationVM.getDateOfBirth()));
//        member.setId(registrationVM.getId());
//
//        if((registrationVM.getGroupId() > 0 )){
//            log.info("Group Id: {}", registrationVM.getGroupId());
//
//            Group group =  new Group();
//            group.setId((int) registrationVM.getGroupId());
//            log.info("GRoup : {}", group);
//            member.setGroup(group);
//        }
//       log.info("saving memmber: {}", member);
       return memberRepository.save(member);

   }
}
