package com.tosan.eg.jersey.repositories;

import com.tosan.eg.jersey.models.Speaker;

import java.util.ArrayList;
import java.util.List;

public class SpeakerRepositoryImpl implements SpeakerRepository {
    private static List<Speaker> speakers;

    public SpeakerRepositoryImpl() {
        speakers = new ArrayList<>();

        Speaker speaker1 = new Speaker(1L, "Bryan Hansen", "Pluralsight");
        Speaker speaker2 = new Speaker(2L, "Jasper de Jong", "Google");

        speakers.add(speaker1);
        speakers.add(speaker2);
    }

    @Override
    public List<Speaker> findAll() {
        return speakers;
    }

    @Override
    public Speaker findById(Long id) {
        return speakers.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Speaker createSpeaker(Speaker speaker) {
        speaker.setId(speakers.size() + 1L);
        speakers.add(speaker);

        return speaker;
    }
}
