package com.babilonia.Babilonia.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer birthYear;
    private Integer deathYear;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LibroEntity> books;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LibroEntity> getBooks() {
        return books;
    }

    public void setBooks(List<LibroEntity> books) {
        this.books = books;
    }
}
