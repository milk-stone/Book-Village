package com.bookvillage.backend.domain.book.service;

import com.bookvillage.backend.domain.book.dto.BookRegisterReq;
import com.bookvillage.backend.domain.book.entity.Book;
import com.bookvillage.backend.domain.book.repository.BookRepository;
import com.bookvillage.backend.domain.copy.entity.Copy;
import com.bookvillage.backend.domain.copy.service.CopyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CopyService copyService;

    @Transactional
    public ResponseEntity<Void> registerBooks(BookRegisterReq dto){
        Book book = Book.toEntity(dto);
        List<Copy> copies = copyService.createCopies(book, dto.count());
        book.addCopies(copies);
        bookRepository.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
