package com.camp.campus.service;

import com.camp.campus.dto.ProfileDTO;

import java.util.List;

public interface ProfilesService {

    Long createProfile(ProfileDTO profileDTO);
    List<ProfileDTO> getProfiles();
}
