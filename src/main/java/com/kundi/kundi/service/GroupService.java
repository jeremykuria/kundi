package com.kundi.kundi.service;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.domain.Topic;
import com.kundi.kundi.domain.enumeration.GroupStatus;
import com.kundi.kundi.domain.enumeration.GroupType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GroupService {

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
        );
    }

    public String getGroups() {
        return  "Test api";
    }

    public Group getGroup(Integer id){
        return groups.stream().filter(g -> g.getId() == id).findFirst().get();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
