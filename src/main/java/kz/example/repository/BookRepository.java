package kz.example.repository;

import kz.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b Where b.is_issued=?1", nativeQuery = true)
    List<Book> findBooksByStatus(boolean isIssued );

    @Query(value = "SELECT * FROM Book b Where b.is_issued=?1", nativeQuery = true)
    List<Book> findNotAvailableBooks(boolean isIssued );
}
