package br.com.victorgadelha.literalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorgadelha.literalura.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
