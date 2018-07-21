package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "artists")
public class Artist extends Advert {

    private String name;
    private Skill skill;
    private String location;
    private String contact;


    public Artist(String title, String description, User user, String name, Skill skill, String location, String contact) {
        super(title, description, user);
        this.name = name;
        this.skill = skill;
        this.location = location;
        this.contact = contact;
    }

    public Artist(){


    }

    @Column(name= "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "skill")
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
