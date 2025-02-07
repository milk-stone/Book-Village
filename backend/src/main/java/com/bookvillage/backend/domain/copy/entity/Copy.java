package com.bookvillage.backend.domain.copy.entity;

import com.bookvillage.backend.domain.book.entity.Book;
import com.bookvillage.backend.domain.member.entity.Member;
import com.bookvillage.backend.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Copy extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "copy_id")
    private Long id;
    private LocalDateTime borrowedAt = null;
    private LocalDateTime expiresAt = null;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Copy(Book book){
        this.book = book;
    }

    public void borrow(Member member){
        this.borrowedAt = LocalDateTime.now();
        this.member = member;
        this.expiresAt = borrowedAt.plusDays(7);
    }

    public void extendDueDate(){
        if (this.expiresAt != null)
            this.expiresAt = this.expiresAt.plusDays(7);
    }
}
