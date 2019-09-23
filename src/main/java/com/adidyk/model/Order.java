package com.adidyk.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_smart_phones",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = { @JoinColumn(name = "smart_phone_id")}
    )
    private List<SmartPhone> smartPhones = new ArrayList<>();

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                Objects.equals(smartPhones, order.smartPhones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smartPhones);
    }


}
