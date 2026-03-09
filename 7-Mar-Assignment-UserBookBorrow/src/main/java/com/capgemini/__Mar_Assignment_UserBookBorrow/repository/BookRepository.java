package com.capgemini.__Mar_Assignment_UserBookBorrow.repository;

import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAvailable(boolean available);
}
