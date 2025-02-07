package com.bookvillage.backend.domain.copy.service;

import com.bookvillage.backend.domain.book.dto.BookRegisterReq;
import com.bookvillage.backend.domain.book.entity.Book;
import com.bookvillage.backend.domain.copy.entity.Copy;
import com.bookvillage.backend.domain.copy.repository.CopyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyServiceImpl implements CopyService {
    private final CopyRepository copyRepository;

    @Transactional
    public List<Copy> createCopies(Book book, int count){
        List<Copy> copies = new ArrayList<>();
        for (int i = 0; i < count; i++){
            copies.add(new Copy(book));
        }
        copyRepository.saveAll(copies);
        return copies;
    }
}
