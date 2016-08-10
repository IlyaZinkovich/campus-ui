package com.camp.campus.controller;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.SearchCriteria;
import com.camp.campus.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(path = "v1/profiles", method = POST)
    public Long createProfile(@RequestBody ProfileDTO poll) {
        return profileService.createProfile(poll);
    }

    @RequestMapping(path = "v1/profiles", method = GET)
    public List<ProfileDTO> getProfiles(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String gender,
                                        @RequestParam(required = false) Integer ageLow,
                                        @RequestParam(required = false) Integer ageHigh,
                                        @RequestParam(required = false) String faculty,
                                        @RequestParam(required = false) String speciality,
                                        @RequestParam(required = false) Integer course,
                                        @RequestParam(required = false) Integer group,
                                        @RequestParam(required = false) Integer page,
                                        @RequestParam(required = false) Integer size) {
        return profileService.getProfiles(new SearchCriteria(name, gender, ageLow, ageHigh, faculty, speciality, course, group), page, size);
    }

    @RequestMapping(path = "v1/profiles/{profileId}", method = GET)
    public ProfileDTO getProfileById(@PathVariable Long profileId) {
        return profileService.getProfileById(profileId);
    }
}
