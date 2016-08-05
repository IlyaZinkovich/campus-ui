package com.camp.campus.service;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.SearchCriteria;

import java.util.List;

public interface ProfilesService {

    Long createProfile(ProfileDTO profileDTO);
    List getProfiles(SearchCriteria searchCriteria, Integer page, Integer size);
    ProfileDTO getProfileById(Long profileId);
}
