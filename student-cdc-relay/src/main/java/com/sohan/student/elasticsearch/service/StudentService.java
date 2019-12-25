package com.sohan.student.elasticsearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sohan.student.elasticsearch.entity.Student;
import com.sohan.student.elasticsearch.repository.StudentRepository;
import com.sohan.student.utils.Operation;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service interface that masks the caller from the implementation that fetches
 * / acts on Student related data.
 *
 * @author Sohan
 */
@Service
public class StudentService {

	/**
	 * Handle to ElasticSearch
	 */
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	/**
	 * Updates/Inserts/Delete student data.
	 *
	 * @param studentData
	 * @param operation
	 */
	public void maintainReadModel(Map<String, Object> studentData, Operation operation) {
		final ObjectMapper mapper = new ObjectMapper();
		final Student student = mapper.convertValue(studentData, Student.class);

		if (Operation.DELETE.name().equals(operation.name())) {
			studentRepository.deleteById(student.getId());
		} else {
			studentRepository.save(student);
		}
	}
}
