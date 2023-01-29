package mongodbexample.repo;

import mongodbexample.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Books, Integer> {
    public Books findById(int id);

    public Books findByAuthor(String author);

}
