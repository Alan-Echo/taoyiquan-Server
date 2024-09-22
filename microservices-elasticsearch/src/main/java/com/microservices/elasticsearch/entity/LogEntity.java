package com.microservices.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "springboot-*")
public class LogEntity {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String message;

    @Field(type = FieldType.Text)
    private String loggerName;

    @Field(type = FieldType.Text)
    private String level;

    @Field(type = FieldType.Text)
    private String stackTrace;

}
