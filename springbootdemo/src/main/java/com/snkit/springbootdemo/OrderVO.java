package com.snkit.springbootdemo;

public class OrderVO {
	
	public OrderVO() {
		
	}

	private Long orderId;
	private Long amt;
	
	private Long quantity;

	public Long getAmt() {
		return amt;
	}

	public void setAmt(Long amt) {
		this.amt = amt;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
	
}
