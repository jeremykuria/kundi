package com.kundi.kundi.service;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.domain.enumeration.GroupStatus;
import com.kundi.kundi.domain.enumeration.GroupType;
import com.kundi.kundi.repository.GroupRepository;
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

    @Autowired
    private GroupRepository groupRepository;

    private List<Group> groups = new ArrayList<>(Arrays.asList(
            new Group(1,
                    "uuId",
                    "Jina",
                    GroupType.YOUTH,
                    "0700585267",
                    "test",
                    "TEST",
                    GroupStatus.ACTIVE,
                    LocalDate.now(),
                    LocalDate.now(),
                    "me",
                    "ME"
                    )
    ));
    public List<Group> getAllGroups(){
        return Arrays.asList(
                new Group(1,
                        "uuId",
                        "Jina",
                        GroupType.YOUTH,
                        "0700585267",
                        "test",
                        "TEST",
                        GroupStatus.ACTIVE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "me",
                        "ME"
                ),
                new Group(2,
                "uuId",
                "Jina",
                GroupType.YOUTH,
                "0700585267",
                "test",
                "TEST",
                GroupStatus.ACTIVE,
                LocalDate.now(),
                LocalDate.now(),
                "me",
                "ME"
                    ),
                new Group(3,
                "uuId",
                "Jina",
                GroupType.YOUTH,
                "0700585267",
                "test",
                "TEST",
                GroupStatus.ACTIVE,
                LocalDate.now(),
                LocalDate.now(),
                "me",
                "ME"
                    )
        );
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
}
