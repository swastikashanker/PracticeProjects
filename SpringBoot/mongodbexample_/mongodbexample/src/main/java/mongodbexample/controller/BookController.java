package mongodbexample.controller;


import mongodbexample.exception.BookFoundException;
import mongodbexample.models.Books;
import mongodbexample.repo.BookRepository;
import mongodbexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mongodbapp")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Books books) {
        try {
            bookService.saveBook(books);

            return new ResponseEntity<>("Book added !!", HttpStatus.OK);
        } catch (BookFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
        }
    }



    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks() {
        List<Books> list = bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Books> getBooksById(@PathVariable int bookId) {

        Books books = bookService.getBooksById(bookId);

        return ResponseEntity.status(HttpStatus.OK).body(books);

    }


    @DeleteMapping("/delete/{bookId}")
    public String deleteUser(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        return "Book with id; " + bookId + " deleted successfully!!";
    }

}
