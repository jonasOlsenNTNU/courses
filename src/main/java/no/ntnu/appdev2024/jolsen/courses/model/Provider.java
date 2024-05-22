package no.ntnu.appdev2024.jolsen.courses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Provider(String name) {
        this.setName(name);
    }

    public Provider() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @JsonIgnore
    public boolean isValid() {
        return (!this.name.isBlank());
    }
}
