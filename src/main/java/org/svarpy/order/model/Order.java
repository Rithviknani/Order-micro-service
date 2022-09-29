package org.svarpy.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	
	@Id
	int orderId;
	int customerId;
	Item item;
	String fullName;
	String email;
	String address;
	String state;
	int pinCode;

	public Order(int orderId, int customerId, Item item, String fullName, String email, String address, String state,
			int pinCode) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.item = item;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", item=" + item + ", fullName=" + fullName
				+ ", email=" + email + ", address=" + address + ", state=" + state + ", pinCode=" + pinCode + "]";
	}

	
}
