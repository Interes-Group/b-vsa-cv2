package sk.stuba.fei.uim.vsa.cv2;

import javax.persistence.*;

@Entity
public class Book {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private double price;

    @Basic
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Book() {
    }
}
