package com.camp.campus.controller;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProfilesController {

    @Autowired
    private ProfilesService profilesService;

    @RequestMapping(path = "v1/profiles", method = POST)
    public Long createProfile(@RequestBody ProfileDTO poll) {
        return profilesService.createProfile(poll);
    }

    @RequestMapping(path = "v1/profiles", method = GET)
    public List<ProfileDTO> getProfiles() {
        return profilesService.getProfiles();
    }
}
