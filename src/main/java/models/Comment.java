package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="comments")
public class Comment {

    private int id;
    private  User user;
    private Advert advert;
    private String text;
    private List<Comment> comments;

    public Comment(){

    }

    public Comment(User user, Advert advert, String text){
        this.user = user;
        this.advert = advert;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "advert_id", nullable = false)
    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
