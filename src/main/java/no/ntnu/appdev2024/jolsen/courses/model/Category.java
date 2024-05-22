package no.ntnu.appdev2024.jolsen.courses.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {}


    @JsonIgnore
    public boolean isValid() {
        return (id >= 0 && !name.isBlank());
    }

    @JsonIgnore
    public String toString() {
        return "Id: " + this.id + " Name: " + this.name;
    }

}
