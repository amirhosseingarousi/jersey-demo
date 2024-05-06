package com.tosan.eg.jersey.resources;

import com.tosan.eg.jersey.models.Speaker;
import com.tosan.eg.jersey.repositories.SpeakerRepository;
import com.tosan.eg.jersey.repositories.SpeakerRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("speaker")
public class SpeakerResource {

    private SpeakerRepository speakerRepository;

    public SpeakerResource() {
        this.speakerRepository = new SpeakerRepositoryImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker findById(@PathParam("id") Long id) {
        return speakerRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker createSpeaker(Speaker speaker) {
        return speakerRepository.createSpeaker(speaker);
    }
}
