package mongodbexample.service;

import mongodbexample.exception.BookFoundException;
import mongodbexample.models.Books;
import mongodbexample.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Books saveBook(Books books) {
        Books newBook = bookRepository.findById(books.getBookId());
        if (newBook != null) {


            throw new BookFoundException("Book already present with " + books.getBookId());
        } else {


            newBook= bookRepository.save(books);
        }
        return newBook;
    }

    @Override
    public List<Books> getAllBooks() {
        List<Books> list = (List<Books>) this.bookRepository.findAll();
        return list;
    }

    @Override
    public Books getBooksById(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public String deleteById(int bookId) {
      bookRepository.deleteById(bookId);
        return bookId+" deleted";
    }

}
