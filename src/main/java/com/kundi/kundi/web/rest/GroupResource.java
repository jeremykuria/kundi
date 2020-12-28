package com.kundi.kundi.web.rest;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Group getGroup(@PathVariable Integer id){
       return this.groupService.getGroup(id);
    }

    @GetMapping("/all")
    public List<Group> getAllGroups(){
        return this.groupService.getAllGroups();
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







}
