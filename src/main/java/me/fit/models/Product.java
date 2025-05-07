package me.fit.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productid;

	private String name;
	private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid")
	private Category category;

	@ManyToMany(mappedBy = "products")
    public Set<AppUser> users;

	public Product() {
	}
	
	
	public Product(Long Id, String name, double price, Category Category) {
		super();
		this.productid = Id;
		this.name = name;
		this.price = price;
		this.category = Category;
	}

	public Long getProductID() {
		return productid;
	}

	public void setProductID(Long productID) {
		this.productid = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategoryID() {
		return category;
	}

	public void setCategoryID(Category Category) {
		this.category = Category;
	}

}
