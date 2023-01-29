package mongodbexample.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Library")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    private int bookId;

    private String bookName;
    private String author;

}
