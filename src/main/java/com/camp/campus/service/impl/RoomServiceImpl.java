package com.camp.campus.service.impl;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.RoomDTO;
import com.camp.campus.model.Profile;
import com.camp.campus.model.Room;
import com.camp.campus.repository.RoomRepository;
import com.camp.campus.repository.RoomSpecification;
import com.camp.campus.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomDTO> findAll(Integer floor, Integer page, Integer size) {
        List<Room> rooms;
        if (page != null && size != null) {
            PageRequest request = new PageRequest(page, size, Sort.Direction.DESC, "roomNumber");
            rooms = roomRepository.findAll(new RoomSpecification(floor), request).getContent();
        } else {
            rooms = roomRepository.findAll(new RoomSpecification(floor));
        }
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