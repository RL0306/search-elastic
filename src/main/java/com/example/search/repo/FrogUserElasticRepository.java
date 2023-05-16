package com.example.search.repo;

import com.example.search.entity.FrogUserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FrogUserElasticRepository extends ElasticsearchRepository<FrogUserDocument, String> {
}
