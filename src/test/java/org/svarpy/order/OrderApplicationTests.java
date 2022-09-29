package org.svarpy.order;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.svarpy.order.model.Item;
import org.svarpy.order.model.Order;
import org.svarpy.order.repo.OrderRepository;
import org.svarpy.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	@Autowired
	private OrderService service;

	@MockBean
	private OrderRepository repository;

	@Test
	public void getOrdersTest() {
		Order order1 = new Order(1, 101, new Item(200, "iPhone 13 pro", "iPhone", 130000), "fullName", "mail", "addr", "state", 500032);
		Order order2 = new Order(2, 101, new Item(201, "iPhone 14 pro", "iPhone", 140000), "fullName2", "mail2", "addr2", "state2", 5000322);
		when(repository.findAll()).thenReturn(Stream
				.of(order1, order2).collect(Collectors.toList()));
		assertEquals(2, service.getAllOrders().size());
	}

	@Test
	public void getOrderByOrderIdTest() {
		int orderId = 1;
		Order order1 = new Order(1, 101, new Item(200, "iPhone 13 pro", "iPhone", 130000), "fullName", "mail", "addr", "state", 500032);
		when(repository.findById(orderId))
				.thenReturn(Optional.of(order1));
		assertEquals(order1, service.getOrderByOrderId(orderId));
	}

	@Test
	public void createOrderTest() {
		Order order1 = new Order(1, 101, new Item(200, "iPhone 13 pro", "iPhone", 130000), "fullName", "mail", "addr", "state", 500032);
		when(repository.save(order1)).thenReturn(order1);
		assertEquals("Order Created Successfully", service.createOrder(order1));
	}
	
	@Test
	public void getOrdersByCustomerIdTest() {
		int customerId = 101;
		Order order1 = new Order(1, 101, new Item(200, "iPhone 13 pro", "iPhone", 130000), "fullName", "mail", "addr", "state", 500032);
		Order order2 = new Order(2, 101, new Item(201, "iPhone 14 pro", "iPhone", 140000), "fullName2", "mail2", "addr2", "state2", 5000322);
		when(repository.findByCustomerId(customerId))
				.thenReturn(Stream
						.of(order1, order2).collect(Collectors.toList()));
		assertEquals(2, service.getOrdersByCustomerId(customerId).size());
	}

	@Test
	public void deleteOrderTest() {
		Order order1 = new Order(1, 101, new Item(200, "iPhone 13 pro", "iPhone", 130000), "fullName", "mail", "addr", "state", 500032);
		service.deleteOrder(order1.getOrderId());
		verify(repository, times(1)).deleteById(order1.getOrderId());
	}
}