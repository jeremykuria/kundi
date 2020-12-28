package com.kundi.kundi.web.rest;

import com.kundi.kundi.domain.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicResource {

    @RequestMapping("/topics")

    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("Spring","SPring FRamewaork", "spring unit"),
                new Topic("Angular web","Angular 10+ web", "Angular mobile"),
                new Topic("CSS","css", "css, scss,sass")
        );
    }
}
