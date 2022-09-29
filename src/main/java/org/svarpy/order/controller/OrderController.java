package org.svarpy.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svarpy.order.model.Order;
import org.svarpy.order.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getAll")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/get/{orderId}")
	public Order getOrderByOrderId(@PathVariable int orderId) {
		return orderService.getOrderByOrderId(orderId);
	}
	
	@GetMapping("/get/user/{customerId}")
	public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
		return orderService.getOrdersByCustomerId(customerId);
	}
	
	@PostMapping("/create")
	public String createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@DeleteMapping("/delete/{orderId}")
	public String deleteOrder(@PathVariable int orderId) {
		return orderService.deleteOrder(orderId);
	}

}
