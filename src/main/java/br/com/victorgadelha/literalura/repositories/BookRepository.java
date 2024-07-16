package br.com.victorgadelha.literalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorgadelha.literalura.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
