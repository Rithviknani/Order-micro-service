package org.svarpy.order.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.svarpy.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

	List<Order> findByCustomerId(int customerId);

}
