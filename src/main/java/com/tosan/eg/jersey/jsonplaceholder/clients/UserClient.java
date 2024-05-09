package com.tosan.eg.jersey.jsonplaceholder.clients;

import com.tosan.eg.jersey.jsonplaceholder.models.user.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class UserClient {
    private final String BASE_URI = "https://jsonplaceholder.typicode.com";
    private Client client;

    public UserClient() {
        this.client = ClientBuilder.newClient();
    }

    public User get(Long id) {
        return client
                .target(BASE_URI)
                .path("users")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(User.class);
    }

    public List<User> get() {
        return client
                .target(BASE_URI)
                .path("users")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<User>>() {});
    }

    public static void main(String[] args) {
        UserClient client = new UserClient();

        User user = client.get(10L);
        List<User> users = client.get();
        System.out.println(users.size());
    }

}
