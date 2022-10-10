package com.example.CategoryMicroservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "category")
@NoArgsConstructor
public class CategoryEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String createdBy;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdDate;

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
