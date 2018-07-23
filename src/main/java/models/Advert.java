package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "adverts")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "advert_type")
public abstract class Advert {

    private int id;
    private String title;
    private String description;
    private User user;
    private String image;
    private List<Comment> comments;

    public Advert(){}

    public Advert(String title, String description, User user){
      this.title = title;
      this.description = description;
      this.user = user;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "advert", fetch = FetchType.LAZY)
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
