package br.com.victorgadelha.literalura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorgadelha.literalura.models.Book;
import br.com.victorgadelha.literalura.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByLanguage(String language) {
        return bookRepository.findBooksByLanguage(language);
    }
}
