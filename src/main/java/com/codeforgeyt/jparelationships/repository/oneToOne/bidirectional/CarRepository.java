package com.codeforgeyt.jparelationships.repository.oneToOne.bidirectional;

import com.codeforgeyt.jparelationships.model.oneToOne.bidirectional.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
