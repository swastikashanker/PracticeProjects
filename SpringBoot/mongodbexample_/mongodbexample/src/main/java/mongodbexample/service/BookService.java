package mongodbexample.service;

import mongodbexample.exception.BookFoundException;
import mongodbexample.models.Books;

import java.util.List;

public interface BookService {
    public Books saveBook(Books books) throws BookFoundException;

    public List<Books> getAllBooks();
    public Books getBooksById (int bookId);
    public String deleteById(int bookId);

}
