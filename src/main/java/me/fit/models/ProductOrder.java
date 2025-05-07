package me.fit.models;

public class ProductOrder {
	private Long productID;
	private Long orderID;
	private int quantity;

	public ProductOrder(Long productID, Long orderID, int quantity) {
		super();
		this.productID = productID;
		this.orderID = orderID;
		this.quantity = quantity;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
