package com.codeforgeyt.jparelationships.repository.oneToMany.bidirectional;

import com.codeforgeyt.jparelationships.model.oneToMany.bidirectional.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
