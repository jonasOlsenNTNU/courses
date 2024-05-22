package no.ntnu.appdev2024.jolsen.courses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private int category;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("level")
    private String level;
    @JsonProperty("credits")
    private int credits;
    @JsonProperty("hours")
    private int hours;
    @JsonProperty("certification")
    private String certification;
    @JsonProperty("keywords")
    private String keywords;

    public Course(int category, String title, String description, String level,
                  int credits, int hours, String certification, String keywords) {
        this.setCategory(category);
        this.setTitle(title);
        this.setDescription(description);
        this.setLevel(level);
        this.setCredits(credits);
        this.setHours(hours);
        this.setCertification(certification);
        this.setKeywords(keywords);
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

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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
