package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "speaksers")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;
    // todo private blob speaker_photo;

    /* we are defining here also many to many relationship bc this makes relationship
    bidirectional */

    @ManyToMany
    @JoinTable(
    name ="session_speakers",
    joinColumns = @JoinColumn(name = "session_id"),
    inverseJoinColumns =  @JoinColumn(name = " speaker_id"))
    private List<Session> sessions;

    public String getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(String speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }


}
