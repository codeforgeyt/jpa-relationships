package com.codeforgeyt.jparelationships.repository.oneToOne.unidirectional;

import com.codeforgeyt.jparelationships.model.oneToOne.unidirectional.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
