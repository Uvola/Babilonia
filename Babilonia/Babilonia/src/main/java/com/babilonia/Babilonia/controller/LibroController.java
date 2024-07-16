package com.babilonia.Babilonia.controller;

import com.babilonia.Babilonia.entity.AutorEntity;
import com.babilonia.Babilonia.entity.LibroEntity;
import com.babilonia.Babilonia.model.Autor;
import com.babilonia.Babilonia.model.Libro;
import com.babilonia.Babilonia.service.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibroController {
    @Autowired
    private LibroServicio libroServicio;

    @GetMapping("/books/{id}/authors")
    public Flux<Autor> getAutoresByLibroId(@PathVariable int id) {
        return libroServicio.getAuthorsByBookId(id);
    }

    @GetMapping("/authors")
    public List<AutorEntity> getAutores() {
        return (List<AutorEntity>) libroServicio.getAuthors();
    }

    @GetMapping("/authors/year")
    public List<AutorEntity> getAutoresByYear(@RequestParam int year) {
        return libroServicio.getAuthorsAliveInYear(year);
    }

    @PostMapping("/books")
    public LibroEntity guardarLibro(@RequestBody Libro libro) {
        return libroServicio.saveBook(libro);
    }

    @GetMapping("/books")
    public List<LibroEntity> getLibros() {
        return libroServicio.getLibros();
    }

    @GetMapping("/books/language")
    public List<LibroEntity> getLibroByLanguage(@RequestParam String language) {
        return libroServicio.getBooksByLanguage(language);
    }
}
