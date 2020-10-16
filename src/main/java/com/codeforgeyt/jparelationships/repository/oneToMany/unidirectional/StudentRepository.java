package com.codeforgeyt.jparelationships.repository.oneToMany.unidirectional;

import com.codeforgeyt.jparelationships.model.oneToMany.unidirectional.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
