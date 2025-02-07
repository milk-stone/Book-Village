package com.bookvillage.backend.domain.book.repository;

import com.bookvillage.backend.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
