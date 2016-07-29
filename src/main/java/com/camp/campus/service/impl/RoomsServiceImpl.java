package com.camp.campus.service.impl;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.RoomDTO;
import com.camp.campus.model.Profile;
import com.camp.campus.model.Room;
import com.camp.campus.repository.RoomsRepository;
import com.camp.campus.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public List<RoomDTO> findAll() {
        List<Room> rooms = roomsRepository.findAll();
        return rooms.stream().map(this::roomToDTO).collect(Collectors.toList());
    }

    private RoomDTO roomToDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setCapacity(room.getCapacity());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setProfiles(room.getProfiles().stream().map(this::profileToDto).collect(Collectors.toList()));
        return dto;
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