package sk.stuba.fei.uim.vsa.cv2;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("sql2java");
        EntityManager manager = managerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(new BookEntity("Silmarillion", 16.15));
        manager.persist(new BookEntity("Hobit", 7.95));
        BookEntity book1 = new BookEntity("Pán prsteňov I. - Spoločenstvo prsteňa", 8.79);
        manager.persist(book1);
        transaction.commit();

        EntityTransaction transaction1 = manager.getTransaction();
        transaction1.begin();
        book1.setPrice(20.0);
        manager.persist(book1);
        transaction1.commit();

        Query query = manager.createNativeQuery("select * from Book", BookEntity.class);
        List<BookEntity> books = query.getResultList();
        for (BookEntity book : books) {
            System.out.println(book.getTitle() + ": " + book.getPrice());
        }
    }
}
