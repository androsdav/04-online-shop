package com.adidyk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class SmartPhone.
 */
@Entity
@Table(name = "smart_phones")
public class SmartPhone {

    /**
     * @param id - id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param company - company.
     */
    @Column(name = "company")
    private String company;

    /**
     * @param model - model.
     */
    @Column(name = "model")
    private String model;

    /**
     * @param description.
     */
    @Column(name = "description")
    private String description;

    /**
     * @param quantity - quantity.
     */
    @Column(name = "quantity")
    private int quantity;

    /**
     * @param price - price.
     */
    @Column(name = "price")
    private double price;

    /**
     * @param orderSmartPhones - order smart phones.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "smartPhone")
    @Fetch(FetchMode.JOIN)
    private List<OrderSmartPhone> orderSmartPhones = new ArrayList<>();

    /**
     * SmartPhone - constructor.
     */
    public SmartPhone() {
    }

    /**
     * SmartPhone - constructor.
     * @param id - id.
     */
    public SmartPhone(int id) {
        this.id = id;
    }

    /**
     * SmartPhone - constructor.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price by one.
     */
    public SmartPhone(String company, String model, String description, int quantity, double price) {
        this.company = company;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
    public void setType(String type) {
        this.type = type;
    }
    */

    /*
    public List<Order> getOrders() {
        return orders;
    }
    */

    /*
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmartPhone)) return false;
        SmartPhone that = (SmartPhone) o;
        return id == that.id &&
                quantity == that.quantity &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(company, that.company) &&
                Objects.equals(model, that.model) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, model, description, quantity, price);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}