package com.bookvillage.backend.domain.book.service;

import com.bookvillage.backend.domain.book.dto.BookRegisterReq;
import org.springframework.http.ResponseEntity;

public interface BookService {
    public ResponseEntity<Void> registerBooks(BookRegisterReq dto);
}
