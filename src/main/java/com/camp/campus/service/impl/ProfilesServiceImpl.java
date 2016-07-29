package com.camp.campus.service.impl;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.model.Profile;
import com.camp.campus.model.Room;
import com.camp.campus.repository.ProfilesRepository;
import com.camp.campus.repository.RoomsRepository;
import com.camp.campus.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfilesServiceImpl implements ProfilesService {

    @Autowired
    private ProfilesRepository profilesRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public Long createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile.ProfileBuilder().firstName(profileDTO.getFirstName()).lastName(profileDTO.getLastName())
                .gender(Profile.Gender.valueOf(profileDTO.getGender()))
                .birthDate(profileDTO.getBirthDate())
                .faculty(profileDTO.getFaculty())
                .speciality(profileDTO.getSpeciality())
                .course(profileDTO.getCourse())
                .group(profileDTO.getGroup())
                .build();
        Room room = roomsRepository.findByRoomNumber(profileDTO.getRoomNumber());
        profile.setRoom(room);
        profilesRepository.save(profile);
        room.getProfiles().add(profile);
        return profile.getId();
    }

    @Override
    public List<ProfileDTO> getProfiles() {
        List<Profile> profiles = (List<Profile>) profilesRepository.findAll();
        return profiles.stream().map(this::profileToDto).collect(Collectors.toList());
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
        return profileDTO;
    }
}
