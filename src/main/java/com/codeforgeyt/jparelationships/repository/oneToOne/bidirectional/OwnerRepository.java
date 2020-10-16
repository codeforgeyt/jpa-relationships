package com.codeforgeyt.jparelationships.repository.oneToOne.bidirectional;

import com.codeforgeyt.jparelationships.model.oneToOne.bidirectional.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
