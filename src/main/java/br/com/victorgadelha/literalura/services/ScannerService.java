package br.com.victorgadelha.literalura.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorgadelha.literalura.DTO.BookDTO;
import br.com.victorgadelha.literalura.models.Author;
import br.com.victorgadelha.literalura.models.Book;
import br.com.victorgadelha.literalura.repositories.AuthorRepository;
import br.com.victorgadelha.literalura.repositories.BookRepository;

@Service
public class ScannerService {

    @Autowired
    ApiService apiService;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    public void getScanner() throws IOException, InterruptedException {

        System.out.println("Digite a opção 1");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Insira o nome do livro que deseja procurar:");
                String title;
                title = scanner.nextLine();

                BookDTO bookDTO = apiService.getApi(title);

                Book book = new Book(bookDTO.title(), bookDTO.authors(), bookDTO.languages(), bookDTO.downloadTotal());

                bookService.save(book);

                System.out.println("book ==>> " + book);
                System.out.println("Livro salvo com sucesso!");

                break;
            case 2:
                List<Book> books = bookService.findAll();
                System.out.println(books);
                break;
            case 3:
                List<Author> authors = authorService.findAll();
                System.out.println(authors);
            default:

                break;
        }
        scanner.close();
    }
}
