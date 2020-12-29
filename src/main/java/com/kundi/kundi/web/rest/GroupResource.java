package com.kundi.kundi.web.rest;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/group")
public class GroupResource {
    private  final Logger log = LoggerFactory.getLogger(GroupResource.class);

    private GroupService groupService;

    public GroupResource(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/register")
    public void registerGroup(@RequestBody Group group){
        log.info("Request to save group: {}", group);
        groupService.addGroup(group);
    }

    @GetMapping("/{id}")
    public Optional getGroup(@PathVariable Integer id){
       return this.groupService.getGroup(id);
    }

    @GetMapping("/all")
    public List<Group> getAllGroups(){
        return this.groupService.getGrps();
    }

    @GetMapping("/groups")
    public String getGroups(){
        log.info("Request to get groups");
        return this.groupService.getGroups();
    }

    @PutMapping("/update}")
    public  void updateGroup(@RequestBody Group group){
        this.groupService.addGroup(group);
    }

    @DeleteMapping("/delete/{id}")
    public  void updateGroup(@PathVariable Integer id){
        this.groupService.deleteGroup(id);
    }







}
