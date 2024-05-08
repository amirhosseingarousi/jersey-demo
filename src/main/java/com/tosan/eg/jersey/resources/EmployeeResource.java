package com.tosan.eg.jersey.resources;

import com.tosan.eg.jersey.models.Employee;
import com.tosan.eg.jersey.repositories.EmployeeRepository;
import com.tosan.eg.jersey.repositories.impl.EmployeeRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("employee")
public class EmployeeResource {
    private EmployeeRepository employeeRepository;

    public EmployeeResource() {
        this.employeeRepository = new EmployeeRepositoryImpl();
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Path("{id}")
    @GET
    public Employee findEmpById(@PathParam("id") Integer id) {
        Employee emp = employeeRepository.findById(id);
        return emp;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmpWithParams(MultivaluedMap<String, String> formParams) {
        Employee emp = new Employee();
        emp.setFirstName(formParams.getFirst("firstName"));
        emp.setLastName(formParams.getFirst("lastName"));
        emp.setJobTitle(formParams.getFirst("jobTitle"));

        return employeeRepository.createEmployee(emp);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    @DELETE
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
