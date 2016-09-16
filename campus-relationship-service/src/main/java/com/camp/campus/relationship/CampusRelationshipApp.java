package com.camp.campus.relationship;

import com.camp.campus.relationship.controller.ControllerConfig;
import com.camp.campus.relationship.repository.GraphRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {GraphRepositoryConfig.class, ControllerConfig.class})
public class CampusRelationshipApp {

    public static void main(String[] args) {
        SpringApplication.run(CampusRelationshipApp.class, args);
    }

}
