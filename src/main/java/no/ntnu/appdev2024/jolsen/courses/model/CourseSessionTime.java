package no.ntnu.appdev2024.jolsen.courses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class CourseSessionTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;
    private Date start;
    private Date end;
    private String location;
    public CourseSessionTime(Date start, Date end, String location) {
        this.setStart(start);
        this.setEnd(end);
        this.setLocation(location);
    }

    public CourseSessionTime() {}

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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

    public int getCourseID() {
        return this.courseID;
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
}
