package com.kundi.kundi.web.rest;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.domain.Member;
import com.kundi.kundi.service.MemberService;
import com.kundi.kundi.web.vm.RegistrationVM;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberResource {

    private  final Logger log = LoggerFactory.getLogger(MemberResource.class);

    private MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody Member member){
        log.info("Request to save memmber: {}", member);
        try {
            memberService.registerMember(member);
            return ResponseEntity.ok().body("Member Created");
        }catch (Exception exception){
            return ResponseEntity.ok().body(exception.getMessage());
        }
    }
    @GetMapping("/{groupId}")
    public List<Member> getGroupMembers(@PathVariable Integer groupId){
        return memberService.groupMembers(groupId);
    }

}
