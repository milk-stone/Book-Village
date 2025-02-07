package com.bookvillage.backend.domain.book.controller;

import com.bookvillage.backend.domain.book.dto.BookRegisterReq;
import com.bookvillage.backend.domain.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/book")
public class BookController {
    private final BookServiceImpl bookService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerBooks(@RequestBody BookRegisterReq dto){
        return bookService.registerBooks(dto);
    }
}
