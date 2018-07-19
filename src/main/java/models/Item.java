package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name= "items")
public class Item  extends Advert{
    private Category category;
    private String price;


    public Item(){}

    public Item(String title, String description, User user, Category category, String price) {
        super(title, description, user);
        this.category = category;
        this.price = price;
    }

    @Column(name= "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name= "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
