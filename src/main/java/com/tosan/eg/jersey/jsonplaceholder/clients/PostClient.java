package com.tosan.eg.jersey.jsonplaceholder.clients;

import com.tosan.eg.jersey.jsonplaceholder.models.Post;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class PostClient {
    private Client client;
    private final String BASE_URI = "https://jsonplaceholder.typicode.com";

    public PostClient() {
        client = ClientBuilder.newClient();
    }

    public Post get(Integer id) {
        return client
                .target(BASE_URI)
                .path("posts/" + String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Post.class);

    }

    public List<Post> get() {
        Response response = client
                .target(BASE_URI)
                .path("posts")
                .request(MediaType.APPLICATION_JSON)
                .get();

        return response
                .readEntity(new GenericType<List<Post>>() {});
    }

    public static void main(String[] args) {
        PostClient client = new PostClient();
        Post post = client.get(100);

        List<Post> posts = client.get();
        System.out.println(posts.size());
    }
}
