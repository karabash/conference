package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.List;

/**
JPA  entities to talk the database structure.
 */
/*we are annotating this is JPA entity with @Entity
 * name = "sessions" because name of the our db table
 * we called the class name Session bc it will be one instance or row of that data
*/
@Entity(name="sessions") // sessions is
public class Session {
    //id annotation specify which attribute is primary key
    //tells JPA that the IDE is primary key field
    @Id
    //specifies how to primary key field gets populated a new record insert
    @GeneratedValue(strategy = GenerationType.IDENTITY) //using Identy strategy JPA utilize the Postgres created sequence for primary key values.

    //obs variable names are not Java standart camelCase bc
    // keeping instance variables name as they are bc
    //they have to be same as database format bc
    //JPA is going to auto-bind columns.
    //we can use canmel case by using @column on each attribute
    private Long session_id;
    private String session_name;
    private String session_description;



    /*JPA sets up the sql join automatically*/
    @ManyToMany //mapping join table in database
    @JoinTable(name = "session_speakers",
            joinColumns = @JoinColumn( name = "session_id"), //defines that join table and the foreign key columns
            inverseJoinColumns = @JoinColumn(name = "speaker_id")) //which


    /* you need to pick one side of your relationship to be owner
   or main definition point of the relationship
   for this i use the Session.java
   So to do i add a List and type is Session.
   This is just another filed on the Session enity
   we have a basic relationship many to many through
   private List<Session> list;
   */
    private List<Speaker> list;

    public List<Speaker> getList() {
        return list;
    }

    public void setList(List<Speaker> list) {
        this.list = list;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    private Integer session_length;
    /**
     * it helps with serialization and deserialization,
     * which be happen when we plug in the controllers
     * to marshal the data into and out of json
     */
    public Session(){


    }
}
