package com.medibook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "specialty") // Como se llama la propiedad en la clase con la que me estoy relacionando.
    @JsonIgnore // Cuando alguien mapee con un dto, que no llame a la propiedad turnos, porque entra en loop infinito.
    private Set<Doctor> doctors;

    public Specialty() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Specialty(String name, String description, Set<Doctor> doctors) {
        this.name = name;
        this.description = description;
        this.doctors = doctors;
    }

    public Specialty(Long id, String name, String description, Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.doctors = doctors;
    }
}
