package com.camp.campus;

import com.camp.campus.controller.ControllerConfig;
import com.camp.campus.repository.RepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {RepositoryConfig.class, ControllerConfig.class})
public class CampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusApplication.class, args);
    }
}
