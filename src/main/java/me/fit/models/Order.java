package me.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = Order.GET_ALL_FOR_USER, query = "Select o from Order o where o.user.id = :id")
})
public class Order {

    public static final String GET_ALL_FOR_USER = "getAllOrdersForUser";

	public static final String GET_ALL = null;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    public Long id;

    @ManyToOne
    @JsonIgnore
    public User user;

    public String orderNumber;

    public Order() {
        super();
    }

    public Order(Long id, String orderNumber, User user) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
