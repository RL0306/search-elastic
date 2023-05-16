package com.example.search.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "users")
public class FrogUserDocument {

    private String id;
    private String frog_Id;
    private String user_name;

    public FrogUserDocument(String frogId, String user_name) {
        this.frog_Id = frogId;
        this.user_name = user_name;
    }
}
