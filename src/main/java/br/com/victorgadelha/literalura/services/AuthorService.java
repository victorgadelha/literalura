package br.com.victorgadelha.literalura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorgadelha.literalura.models.Author;
import br.com.victorgadelha.literalura.repositories.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void save(Author authors) {
        authorRepository.save(authors);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findAliveAuthorsInYear(int year) {
        return authorRepository.findAliveAuthorsInYear(year);
    };
}
