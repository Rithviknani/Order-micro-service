package org.svarpy.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.svarpy.order.model.Order;
import org.svarpy.order.repo.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrderByOrderId(int orderId) {
		return orderRepository.findById(orderId).get();
	}
	
	public List<Order> getOrdersByCustomerId(int customerId) {
		return orderRepository.findByCustomerId(customerId);
	}
	
	public String createOrder(Order order) {
		try {
			orderRepository.save(order);
			return "Order Created Successfully";
		}
		catch (Exception e) {
			return "Failed to Create Order, Try Again!";
		}
	}
	
	public String deleteOrder(int orderId) {
		try {
			orderRepository.deleteById(orderId);
			return "Order Deleted Successfully";
		}
		catch (Exception e) {
			return "Failed to Delete Order, Try Again!";
		}
	}

}
