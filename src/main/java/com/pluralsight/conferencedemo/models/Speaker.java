package com.pluralsight.conferencedemo.models;
import org.hibernate.annotations.Type;
import javax.persistence.*;
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
    private byte[] speaker_photo;

    @Lob // large object - helps jpa deal with the larger data
    @Type(type = "org.hibernate.type.BinaryType") // hepls hibranate dealing with binary data,
    // in our case hibranate is the JPA implementation that we are using under the covers.
    // Without Type annotation
    //we end end up with an exception whrn jpa
    // queries the data and tries to push it into the Session intstance

    /* we are defining here also many to many relationship bc this makes relationship
    bidirectional */
    @ManyToMany(mappedBy = "speakers") //refering to the attribute on the Sessions class called the speakers
    @JoinTable(
    name ="session_speakers",
    joinColumns = @JoinColumn(name = "session_id"),
    inverseJoinColumns =  @JoinColumn(name = " speaker_id"))
    private List<Session> sessions;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
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

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }
}
