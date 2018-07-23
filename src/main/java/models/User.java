package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "users")
public class User {

    private int id;
    private String username;
    private List<Advert> adverts;
    private String image;
    private List<Comment> comments;

    public User(){

    }

    public User(String username){
        this.username = username;
        this.image = null;

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

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    @Column(name ="images")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addCommentToList(Comment comment){
        this.comments.add(comment);
    }
}
