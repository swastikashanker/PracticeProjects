package com.globallogic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Tutorial")
public class Tutorial {
    private long id;
    private String title;
    private String description;
    private String publishedStatus;
}
