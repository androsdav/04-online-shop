package com.adidyk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Class order.
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
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "user_id")
    //@JsonIgnore
    private User user;

    /**
     * @param smartPhones - list smart phones.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "orders_smart_phones",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "smart_phone_id")}
    )
    private List<SmartPhone> smartPhones = new ArrayList<>();

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
     * @param smartPhones - list smart phones.
     */
    public Order(Date dateCreate, User user, List<SmartPhone> smartPhones) {
        this.dateCreate = dateCreate;
        this.user = user;
        this.smartPhones = smartPhones;
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

    public List<SmartPhone> getSmartPhones() {
        return smartPhones;
    }

    public void setSmartPhones(List<SmartPhone> smartPhones) {
        this.smartPhones = smartPhones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(dateCreate, order.dateCreate) &&
                Objects.equals(user, order.user) &&
                Objects.equals(smartPhones, order.smartPhones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreate, user, smartPhones);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", smartPhones=" + smartPhones +
                ", smartPhones=" + user +
                '}';
    }

}