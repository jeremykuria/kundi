package com.kundi.kundi.service;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.domain.Member;
import com.kundi.kundi.domain.enumeration.Authority;
import com.kundi.kundi.domain.enumeration.GroupStatus;
import com.kundi.kundi.domain.enumeration.GroupType;
import com.kundi.kundi.repository.GroupRepository;
import com.kundi.kundi.repository.MemberRepository;
import com.kundi.kundi.security.error.EmailAlreadyUsedException;
import com.kundi.kundi.service.util.GmailUtil;
import com.kundi.kundi.web.vm.RegisterGroupVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final Logger log = LoggerFactory.getLogger(GroupService.class);

    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;

    public GroupService(GroupRepository groupRepository, MemberRepository memberRepository) {
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
    }

    public String getGroups() {
        return  "Test api";
    }

    public Optional getGroup(Integer id){

        //return groups.stream().filter(g -> g.getId() == id).findFirst().get();
    return groupRepository.findById(id);
    }

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }

    public  List<Group> getGrps(){
        List<Group> groups =  new ArrayList<>();
        groups = (List<Group>) groupRepository.findAll();

        return  groups;
    }

    public void registerGroup(RegisterGroupVM registerGroupVM) throws EmailAlreadyUsedException {

        log.info("Request to register user : {}", registerGroupVM);

        if(emailExists(registerGroupVM.getEmail())){
            throw new EmailAlreadyUsedException("Email Already used");
        }
        //create Group Object
        Group group = new Group();

        group.setName(registerGroupVM.getName());
        group.setEmail(registerGroupVM.getEmail());
        group.setPhoneNumber(registerGroupVM.getPhoneNumber());

        Group registeredGroup = groupRepository.save(group);

        log.info("Registered Group: {}", registeredGroup);
        Member member =  new Member();
        member.setAuthority(Authority.ADMIN);
        member.setEmail(registeredGroup.getEmail());
        member.setPhoneNumber(registeredGroup.getPhoneNumber());
        member.setGroupId(registeredGroup.getId());

        log.info("Registering Member: {}", member);
        memberRepository.save(member);

    }

    public boolean emailExists(String email) {
        log.info("Request to check whether : {} already exists", email);

        Optional<Member> member = memberRepository.findByEmailIgnoreCase(email);
        if (member.isPresent()) {
            return true;
        } else if (email.endsWith("@gmail.com")) {
            log.info("Email is a gmail. Checking for duplicates");
            // check gmail
            return GmailUtil.isDuplicate(memberRepository.findByEmailContaining("@gmail.com"), email, log);
        } else
            return false;
    }
}
