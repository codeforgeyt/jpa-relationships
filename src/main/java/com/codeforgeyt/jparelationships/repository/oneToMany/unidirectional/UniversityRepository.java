package com.codeforgeyt.jparelationships.repository.oneToMany.unidirectional;

import com.codeforgeyt.jparelationships.model.oneToMany.unidirectional.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> {
}
