package com.adidyk.model.pojo;

import com.adidyk.model.dto.UserDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Class Order.
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * @param id - order id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param dateCreate - date create of order.
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    private Date dateCreate = new Date();

    /**
     * @param user - user.
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * @param orderSmartPhones - order smart phones.
     */
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order", orphanRemoval = true)
    //@Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order", orphanRemoval = true)
    private List<OrderProduct> orderProduct = new ArrayList<>();

    /**
     * Order - constructor.
     */
    public Order() {
    }

    /**
     * Order - constructor.
     * @param dateCreate - date create order.
     */
    public Order(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * Order - constructor.
     * @param dateCreate - date create order.
     * @param user - user.
     */
    public Order(int id, Date dateCreate, User user) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.user = user;

        /*this.smartPhones = smartPhones;*/
    }

    public Order(int id, Date dateCreate) {
        this.id = id;
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(dateCreate, order.dateCreate) &&
                Objects.equals(user, order.user) &&
                Objects.equals(orderProduct, order.orderProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCreate, user, orderProduct);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", user=" + user +
                //", orderProduct=" + orderProduct +
                '}';
    }
}