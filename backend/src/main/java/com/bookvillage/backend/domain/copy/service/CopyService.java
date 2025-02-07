package com.bookvillage.backend.domain.copy.service;

import com.bookvillage.backend.domain.book.entity.Book;
import com.bookvillage.backend.domain.copy.entity.Copy;

import java.util.List;

public interface CopyService {
    public List<Copy> createCopies(Book book, int count);
}
