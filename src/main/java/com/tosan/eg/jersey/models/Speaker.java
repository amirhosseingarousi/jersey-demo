package com.tosan.eg.jersey.models;

public class Speaker {
    private Long id;
    private String name;
    private String company;

    public Speaker(Long id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    // Default contructor
    public Speaker() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
