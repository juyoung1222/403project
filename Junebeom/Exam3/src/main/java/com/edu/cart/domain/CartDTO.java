package com.edu.cart.domain;

import java.util.Date;

public class CartDTO {
	
	private int cartno;
	private int cartproductid;
	private Date cartdate;
	private String cartuserid;
	
	
	
	@Override
	public String toString() {
		return "CartDTO [cartno=" + cartno + ", cartproductid=" + cartproductid + ", cartdate=" + cartdate
				+ ", cartuserid=" + cartuserid + "]";
	}



	public int getCartno() {
		return cartno;
	}



	public void setCartno(int cartno) {
		this.cartno = cartno;
	}



	public int getCartproductid() {
		return cartproductid;
	}



	public void setCartproductid(int cartproductid) {
		this.cartproductid = cartproductid;
	}



	public Date getCartdate() {
		return cartdate;
	}



	public void setCartdate(Date cartdate) {
		this.cartdate = cartdate;
	}



	public String getCartuserid() {
		return cartuserid;
	}



	public void setCartuserid(String cartuserid) {
		this.cartuserid = cartuserid;
	}



	public CartDTO(int cartno, int cartproductid, Date cartdate, String cartuserid) {
		super();
		this.cartno = cartno;
		this.cartproductid = cartproductid;
		this.cartdate = cartdate;
		this.cartuserid = cartuserid;
	}
	
	
	

}
