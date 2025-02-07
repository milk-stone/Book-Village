package com.bookvillage.backend.domain.book.entity;

import com.bookvillage.backend.domain.book.dto.BookRegisterReq;
import com.bookvillage.backend.domain.copy.entity.Copy;
import com.bookvillage.backend.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String contents;
    private String category;
    private String img;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies = new ArrayList<>();

    public static Book toEntity(BookRegisterReq dto){
        return new Book(dto.title(), dto.author(), dto.publisher(), dto.contents(), dto.category(), dto.img());
    }

    public void addCopies(List<Copy> copies){
        this.copies.addAll(copies);
    }

    public Book(String title, String author, String publisher, String contents, String category, String img) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.contents = contents;
        this.category = category;
        this.img = img;
    }
}
