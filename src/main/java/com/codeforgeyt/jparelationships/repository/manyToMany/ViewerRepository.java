package com.codeforgeyt.jparelationships.repository.manyToMany;

import com.codeforgeyt.jparelationships.model.manyToMany.Viewer;
import org.springframework.data.repository.CrudRepository;

public interface ViewerRepository extends CrudRepository<Viewer, Long> {
}
