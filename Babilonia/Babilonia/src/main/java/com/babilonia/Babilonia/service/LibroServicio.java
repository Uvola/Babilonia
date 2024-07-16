package com.babilonia.Babilonia.service;

import com.babilonia.Babilonia.entity.AutorEntity;
import com.babilonia.Babilonia.entity.LibroEntity;
import com.babilonia.Babilonia.model.Autor;
import com.babilonia.Babilonia.model.Libro;
import com.babilonia.Babilonia.repository.AutorRepository;
import com.babilonia.Babilonia.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    private final WebClient webClient;

    public LibroServicio(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://gutendex.com").build();
    }

    public Mono<Libro> getBookById(int id) {
        return this.webClient.get()
                .uri("/books/{id}", id)
                .retrieve()
                .bodyToMono(Libro.class);
    }

    public Flux<Libro> getBooksByTitle(String title) {
        return this.webClient.get()
                .uri("/books?search={title}", title)
                .retrieve()
                .bodyToFlux(Libro.class);
    }

    public Flux<Autor> getAuthorsByBookId(int id) {
        return getBookById(id)
                .flatMapMany(libro -> Flux.fromIterable(libro.getAuthors()));
    }

    public Flux<Autor> getAuthors() {
        return this.webClient.get()
                .uri("/authors")
                .retrieve()
                .bodyToFlux(Autor.class);
    }

    public Flux<Autor> getAuthorsByYear(int year) {
        return this.getAuthors()
                .filter(autor -> (autor.getBirthYear() != null && autor.getBirthYear() <= year) &&
                        (autor.getDeathYear() == null || autor.getDeathYear() >= year));
    }

    public LibroEntity saveBook(Libro libro) {
        AutorEntity autorEntity = autorRepository.findById(libro.getAuthors().get(0).getId())
                .orElseGet(() -> {
                    AutorEntity newAutor = new AutorEntity();
                    newAutor.setName(libro.getAuthors().get(0).getName());
                    newAutor.setBirthYear(libro.getAuthors().get(0).getBirthYear());
                    newAutor.setDeathYear(libro.getAuthors().get(0).getDeathYear());
                    return autorRepository.save(newAutor);
                });

        LibroEntity libroEntity = new LibroEntity();
        libroEntity.setTitle(libro.getTitle());
        libroEntity.setAuthor(autorEntity);
        libroEntity.setLanguage(libro.getLanguages().get(0));  // Assuming only one language
        libroEntity.setDownloadCount(libro.getDownloadCount());
        return libroRepository.save(libroEntity);
    }

    public List<LibroEntity> getLibros() {
        return libroRepository.findAll();
    }

    public List<LibroEntity> getBooksByLanguage(String language) {
        return libroRepository.findByLanguage(language);
    }

    public List<AutorEntity> getAuthorsAliveInYear(int year) {
        return autorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
    }
}