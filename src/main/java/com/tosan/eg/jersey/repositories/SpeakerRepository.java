package com.tosan.eg.jersey.repositories;

import com.tosan.eg.jersey.models.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
    Speaker findById(Long id);
    Speaker createSpeaker(Speaker speaker);
}
