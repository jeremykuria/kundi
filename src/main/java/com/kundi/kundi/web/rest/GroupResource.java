package com.kundi.kundi.web.rest;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.security.error.EmailAlreadyUsedException;
import com.kundi.kundi.service.GroupService;
import com.kundi.kundi.service.errors.NotFoundException;
import com.kundi.kundi.web.vm.RegisterGroupVM;
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
    public void registerGroup(@RequestBody RegisterGroupVM registerGroupVM) throws EmailAlreadyUsedException {
        log.debug("Request to save group: {}", registerGroupVM);
        groupService.registerGroup(registerGroupVM);
    }

    @GetMapping("/{id}")
    public Optional getGroup(@PathVariable Integer id){
       Optional group =  this.groupService.getGroup(id);
       if(group ==  null){
        throw new NotFoundException("Resource not found");
       }

       return group;
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
