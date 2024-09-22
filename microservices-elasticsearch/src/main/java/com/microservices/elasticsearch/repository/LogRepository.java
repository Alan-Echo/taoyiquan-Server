package com.microservices.elasticsearch.repository;

import com.microservices.elasticsearch.entity.LogEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Elasticsearch Repository
 */
public interface LogRepository extends ElasticsearchRepository<LogEntity, String> {
    List<LogEntity> findByMessage(String message);

    List<LogEntity> findByLevel(String level);

    List<LogEntity> findByMessageAndLevel(String message, String level);

}
