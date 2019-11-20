package com.sohan.student.elasticsearch.repository;

import com.sohan.student.elasticsearch.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides handles to database, to perform CRUD operations on the index `STUDENT`.
 * The index is represented by the JPA entity {@link Student}.
 *
 * @author Sohan
 * @see ElasticsearchRepository
 */
@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, Integer> {
}
