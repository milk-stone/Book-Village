package com.bookvillage.backend.domain.member.entity;

import com.bookvillage.backend.domain.copy.entity.Copy;
import com.bookvillage.backend.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    private String phone;

    @OneToMany(mappedBy = "member")
    private List<Copy> rentalBooks;

    public Member(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
}
