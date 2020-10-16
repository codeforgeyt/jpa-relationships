package com.codeforgeyt.jparelationships.repository.manyToMany;

import com.codeforgeyt.jparelationships.model.manyToMany.Stream;
import org.springframework.data.repository.CrudRepository;

public interface StreamRepository extends CrudRepository<Stream, Long> {
}
