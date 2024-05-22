package no.ntnu.appdev2024.jolsen.courses.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users_Courses")
public class UsersCourses {

    @Id
    @JsonProperty("uid")
    private int uid;
    @JsonProperty("cid")
    private int cid;
    @JsonProperty("status")
    private String status;
    @JsonProperty("isFavorite")
    private boolean isFavorite;

    public UsersCourses(int uid, int cid, String status) {
        this.uid = uid;
        this.cid = cid;
        this.status = status;
    }

    public UsersCourses() {}

    public int getUid() {
        return this.uid;
    }

    public int getCid() {
        return this.cid;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }

    public void makeFavorite() {
        this.isFavorite = true;
    }

    public void makeNotFavorite() {
        this.isFavorite = false;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setUid(int userId) {
        this.uid = uid;
    }

    public void setCid(int courseId) {
        this.cid = courseId;
    }

    @JsonIgnore
    public boolean isValid() {
        return (this.cid >= 0 && this.uid >= 0);
    }

}
