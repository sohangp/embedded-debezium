package com.sohan.student.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * ElasticSearch Student entity
 */
@Data
@Document(indexName = "student", shards = 1,replicas = 0,refreshInterval = "-1")
public class Student {
    @Id
    private Integer id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Text)
    private String email;
}
