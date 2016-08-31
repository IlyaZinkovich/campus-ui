package com.camp.campus.service.impl;

import com.camp.campus.dto.EventDTO;
import com.camp.campus.dto.LikeEventDTO;
import com.camp.campus.model.Event;
import com.camp.campus.model.Profile;
import com.camp.campus.repository.EventRepository;
import com.camp.campus.repository.ProfileRepository;
import com.camp.campus.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<EventDTO> findByProfileId(Long profileId) {
        return eventRepository.findByProfileId(profileId).stream().map(this::eventToDto).collect(Collectors.toList());
    }

    @Override
    public void saveLikeEvent(LikeEventDTO likeEvent) {
        Profile profile = profileRepository.findOne(likeEvent.getProfileId());
        Profile likeProfile = profileRepository.findOne(likeEvent.getLikeProfileId());
        Event event = getEvent(profile, likeProfile);
        eventRepository.save(event);
        event = getEvent(likeProfile, profile);
        eventRepository.save(event);
    }

    private Event getEvent(Profile profile, Profile likeProfile) {
        String title = "Like";
        String body = likeProfile.getFirstName() + " " + likeProfile.getLastName() + " likes you";
        return new Event(title, body, profile);
    }

    private EventDTO eventToDto(Event event) {
        return new EventDTO(event.getId(), event.getTitle(), event.getBody(), event.getProfile().getId());
    }

}
