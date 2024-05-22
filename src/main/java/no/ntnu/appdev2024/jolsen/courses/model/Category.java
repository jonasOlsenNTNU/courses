package no.ntnu.appdev2024.jolsen.courses.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    private int id;
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

}
