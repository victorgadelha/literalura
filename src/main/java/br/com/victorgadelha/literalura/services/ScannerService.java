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
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Insira o nome do livro que deseja procurar:");
                    String title;
                    title = scanner.nextLine();

                    BookDTO bookDTO = apiService.getApi(title);

                    Book book = new Book(bookDTO.title(), bookDTO.authors(), bookDTO.languages(),
                            bookDTO.downloadTotal());

                    bookService.save(book);

                    System.out.println(book);
                    System.out.println("Livro salvo com sucesso!");
                    break;

                case 2:
                    List<Book> books = bookService.findAll();
                    System.out.println(books);
                    break;

                case 3:
                    List<Author> authors = authorService.findAll();
                    System.out.println(authors);
                    break;

                case 4:
                    System.out.println("Digite o ano que deseja pesquisar:");
                    int year = scanner.nextInt();
                    List<Author> aliveAuthorsInYear = authorService.findAliveAuthorsInYear(year);
                    System.out.println(aliveAuthorsInYear);
                    break;
                case 5:
                    System.out.println("Digite o idioma que deseja pesquisar:");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.findBooksByLanguage(language);
                    System.out.println(booksByLanguage);
                    break;
                case 0:
                    System.out.println("Obrigado por visitar o LiterAlura!");
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
            }
        } while (choice != 0);
        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private void printMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Buscar livro por título");
        System.out.println("2. Listar todos os livros");
        System.out.println("3. Listar todos os autores");
        System.out.println("4. Buscar autores por ano de nascimento");
        System.out.println("5. Buscar livros por idioma");
        System.out.println("0. Sair do programa");
        System.out.print("Escolha uma opção: ");
    }
}
