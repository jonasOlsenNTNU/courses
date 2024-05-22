package no.ntnu.appdev2024.jolsen.courses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int category;
    private String title;
    private String description;
    private String level;
    private int credits;
    private int hours;
    private String certification;

    public Course(int category, String title, String description, String level,
                  int credits, int hours, String certification) {
        this.setCategory(category);
        this.setTitle(title);
        this.setDescription(description);
        this.setLevel(level);
        this.setCredits(credits);
        this.setHours(hours);
        this.setCertification(certification);
    }

    public Course() {}

    public void setID(int id) {
        this.id = id;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public int getID() {
        return this.id;
    }

    public int getCategory() {
        return this.category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLevel() {
        return this.level;
    }

    public int getCredits() {
        return this.credits;
    }

    public int getHours() {
        return this.hours;
    }

    public String getCertification() {
        return this.certification;
    }

    @JsonIgnore
    public boolean isValid() {
        return (!title.isBlank() &&
                !description.isBlank() &&
                !level.isBlank() &&
                credits >= 0 &&
                hours > 0 &&
                !certification.isBlank());

    }

}
