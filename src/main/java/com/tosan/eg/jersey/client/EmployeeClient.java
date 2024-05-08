package com.tosan.eg.jersey.client;

import com.tosan.eg.jersey.models.Employee;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class EmployeeClient {
    private Client client;
    private final String EMPLOYEE_URI = "http://localhost:8080/employee";

    public EmployeeClient() {
        this.client = ClientBuilder.newClient();
    }

    public Employee get(Integer id) {
        return client
                .target(EMPLOYEE_URI)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Employee.class);
    }

    public List<Employee> get() {
        Response response = client
                .target(EMPLOYEE_URI)
                .path("all")
                .request(MediaType.APPLICATION_JSON)
                .get();

        return response
                .readEntity(new GenericType<List<Employee>>() {});
    }

    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();
//        Employee emp = client.get(22);

        client.get()
                .forEach(System.out::println);
    }
}
