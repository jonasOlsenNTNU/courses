package no.ntnu.appdev2024.jolsen.courses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class CourseSessionTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private Date start;
    private Date end;
    private String location;
    public CourseSessionTime(Date start, Date end, String location) {
        this.setStart(start);
        this.setEnd(end);
        this.setLocation(location);
    }

    public CourseSessionTime() {}

    public void setCid(int courseID) {
        this.cid = courseID;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCid() {
        return this.cid;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }

    public String getLocation() {
        return this.location;
    }


    /**
     * TODO: Unsure how to implmement.
     *
     * @return True if the CourseSessionTime object is valid for the DB.
     */
    @JsonIgnore
    public boolean isValid() {
        return true;
    }
}
