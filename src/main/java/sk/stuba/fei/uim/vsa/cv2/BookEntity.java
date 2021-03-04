package sk.stuba.fei.uim.vsa.cv2;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Book", schema = "vsa", catalog = "")
public class BookEntity {
    private Long id;
    private double price;
    private String title;

    public BookEntity(String title, double price) {
        this.price = price;
        this.title = title;
    }

    public BookEntity() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, title);
    }
}
