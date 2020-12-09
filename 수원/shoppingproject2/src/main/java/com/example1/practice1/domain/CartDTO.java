package com.example1.practice1.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartDTO {
		
			int		cartno;
			int		cartproductid;
			Date	cartdate;
			String	cartuserid;
			String	productimagefile;
			String	productimageName;
			String	productimageOriName;
			String	productimageUrl;
			String	productname;
			int		productprice;
			int		productsalescnt;
			
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
			public String getProductimagefile() {
				return productimagefile;
			}
			public void setProductimagefile(String productimagefile) {
				this.productimagefile = productimagefile;
			}
			public String getProductimageName() {
				return productimageName;
			}
			public void setProductimageName(String productimageName) {
				this.productimageName = productimageName;
			}
			public String getProductimageOriName() {
				return productimageOriName;
			}
			public void setProductimageOriName(String productimageOriName) {
				this.productimageOriName = productimageOriName;
			}
			public String getProductimageUrl() {
				return productimageUrl;
			}
			public void setProductimageUrl(String productimageUrl) {
				this.productimageUrl = productimageUrl;
			}
			public String getProductname() {
				return productname;
			}
			public void setProductname(String productname) {
				this.productname = productname;
			}
			public int getProductprice() {
				return productprice;
			}
			public void setProductprice(int productprice) {
				this.productprice = productprice;
			}
			public int getProductsalescnt() {
				return productsalescnt;
			}
			public void setProductsalescnt(int productsalescnt) {
				this.productsalescnt = productsalescnt;
			}
			
			@Override
			public String toString() {
				return "CartDTO [cartno=" + cartno + ", cartproductid=" + cartproductid + ", cartdate=" + cartdate
						+ ", cartuserid=" + cartuserid + ", productimagefile=" + productimagefile
						+ ", productimageName=" + productimageName + ", productimageOriName=" + productimageOriName
						+ ", productimageUrl=" + productimageUrl + ", productname=" + productname + ", productprice="
						+ productprice + ", productsalescnt=" + productsalescnt + "]";
			}

			
}


