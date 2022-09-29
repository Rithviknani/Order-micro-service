package org.svarpy.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {

	@Id
	int itemId;
	String itemName;
	String itemCat;
	int itemPrice;
	
	public Item(int itemId, String itemName, String itemCat, int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCat = itemCat;
		this.itemPrice = itemPrice;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCat() {
		return itemCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCat=" + itemCat + ", itemPrice=" + itemPrice
				+ "]";
	}
	
}
