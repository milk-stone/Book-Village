package com.bookvillage.backend.domain.copy.repository;

import com.bookvillage.backend.domain.copy.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Integer> {
}
