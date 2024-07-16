package com.babilonia.Babilonia.repository;

import com.babilonia.Babilonia.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    List<LibroEntity> findByLanguage(String language);
}
