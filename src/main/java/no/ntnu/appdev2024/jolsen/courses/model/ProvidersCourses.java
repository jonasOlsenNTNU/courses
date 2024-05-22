package no.ntnu.appdev2024.jolsen.courses.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Providers_Courses")
public class ProvidersCourses {

    @Id
    @JsonProperty("pid")
    private int pid;
    @JsonProperty("cid")
    private int cid;
    @JsonProperty("cost")
    private int cost;
    @JsonProperty("currency")
    private String currency;

    public ProvidersCourses(int pid, int cid, int cost, String currency) {
        this.pid = pid;
        this.cid = cid;
        this.cost = cost;
        this.currency = currency;
    }

    public ProvidersCourses() {}

    public int getPid() {
        return this.pid;
    }

    public int getCid() {
        return this.cid;
    }

    public int getCost() {
        return this.cost;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setPid(int providerId) {
        this.pid = providerId;
    }

    public void setCid(int courseId) {
        this.cid = courseId;
    }

    public void setCost(int cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost has to be 0 or higher.");
        }
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonIgnore
    public boolean isValid() {
        return (this.cost >= 0 && !this.currency.isBlank());
    }

}
