package me.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = Orders.GET_ALL_FOR_USER, query = "Select o from Orders o where o.user.id = :id")
})
public class Orders {

    public static final String GET_ALL_FOR_USER = "getAllOrdersForUser";

	public static final String GET_ALL = null;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    public Long id;

    @ManyToOne
    @JsonIgnore
    public AppUser user;

    public String orderNumber;

    public Orders() {
        super();
    }

    public Orders(Long id, String orderNumber, AppUser user) {
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

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
