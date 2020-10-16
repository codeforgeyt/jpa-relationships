package com.codeforgeyt.jparelationships.repository.oneToOne.unidirectional;

import com.codeforgeyt.jparelationships.model.oneToOne.unidirectional.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
