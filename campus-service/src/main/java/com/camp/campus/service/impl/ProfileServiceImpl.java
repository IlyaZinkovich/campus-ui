package com.camp.campus.service.impl;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.SearchCriteria;
import com.camp.campus.model.Profile;
import com.camp.campus.model.Room;
import com.camp.campus.repository.ProfileRepository;
import com.camp.campus.repository.implementation.ProfileSpecification;
import com.camp.campus.repository.RoomRepository;
import com.camp.campus.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Long createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile.ProfileBuilder().firstName(profileDTO.getFirstName()).lastName(profileDTO.getLastName())
                .gender(Profile.Gender.valueOf(profileDTO.getGender()))
                .birthDate(profileDTO.getBirthDate())
                .faculty(profileDTO.getFaculty())
                .speciality(profileDTO.getSpeciality())
                .course(profileDTO.getCourse())
                .group(profileDTO.getGroup())
                .imagePath(profileDTO.getImagePath())
                .build();
        Room room = roomRepository.findByRoomNumber(profileDTO.getRoomNumber());
        profile.setRoom(room);
        profileRepository.save(profile);
        room.getProfiles().add(profile);
        return profile.getId();
    }

    @Override
    public List<ProfileDTO> getProfiles(SearchCriteria searchCriteria, Integer page, Integer size) {
        List<Profile> profiles;
        if (page != null && size != null) {
            PageRequest request = new PageRequest(page, size, Sort.Direction.ASC, "firstName");
            profiles = profileRepository.findAll(new ProfileSpecification(searchCriteria), request).getContent();
        } else {
            profiles = profileRepository.findAll(new ProfileSpecification(searchCriteria));
        }
        return profiles.stream().map(this::profileToDto).collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getProfileById(Long profileId) {
        return profileToDto(profileRepository.findOne(profileId));
    }

    private ProfileDTO profileToDto(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setFirstName(profile.getFirstName());
        profileDTO.setLastName(profile.getLastName());
        profileDTO.setGender(profile.getGender().name());
        profileDTO.setBirthDate(profile.getBirthDate());
        profileDTO.setFaculty(profile.getFaculty());
        profileDTO.setSpeciality(profile.getSpeciality());
        profileDTO.setCourse(profile.getCourse());
        profileDTO.setGroup(profile.getGroup());
        profileDTO.setRoomNumber(profile.getRoom().getRoomNumber());
        profileDTO.setImagePath(profile.getImagePath());
        return profileDTO;
    }
}
