package com.codeforgeyt.jparelationships.repository.oneToMany.bidirectional;

import com.codeforgeyt.jparelationships.model.oneToMany.bidirectional.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
