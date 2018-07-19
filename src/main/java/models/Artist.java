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


    public Artist(String title, String description, User user, String name, Skill skill, String location) {
        super(title, description, user);
        this.name = name;
        this.skill = skill;
        this.location = location;
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


    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
