package com.camp.campus.service.impl;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.UserDTO;
import com.camp.campus.exceptions.AuthenticationException;
import com.camp.campus.model.Profile;
import com.camp.campus.model.User;
import com.camp.campus.repository.UserRepository;
import com.camp.campus.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProfileDTO authenticate(UserDTO userDTO) {
        User user = userRepository.findByName(userDTO.getName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        if (passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            return profileToDto(user.getProfile());
        }
        throw new AuthenticationException();
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
