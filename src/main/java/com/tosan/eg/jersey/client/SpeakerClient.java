package com.tosan.eg.jersey.client;

import com.tosan.eg.jersey.models.Speaker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


public class SpeakerClient {
    private Client client;
    private final String SPEAKER_URI = "http://localhost:8080/speaker";

    public SpeakerClient() {
        client = ClientBuilder.newClient();
    }

    public Speaker get(Long id) {
        return client
                .target(SPEAKER_URI)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Speaker.class);
    }

    public List<Speaker> get() {
        Response response = client
                .target(SPEAKER_URI)
                .request(MediaType.APPLICATION_JSON)
                .get();

        return response
                .readEntity(new GenericType<List<Speaker>>() {});
    }

    public Speaker post(Speaker speaker) {
        Response response = client
                .target(SPEAKER_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(speaker, MediaType.APPLICATION_JSON));

        return response.readEntity(Speaker.class);
    }

    public static void main(String[] args) {
        SpeakerClient client = new SpeakerClient();
        Speaker speaker = client.get(2L);
//        System.out.println(speaker);

//        client.get().forEach(System.out::println);

        Speaker speaker1 = new Speaker();
        speaker1.setName("John");
        speaker1.setCompany("Amazon");

        Speaker speaker2 = client.post(speaker1);
        System.out.println(speaker2);
    }
}
