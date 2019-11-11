package com.adidyk.model.pojo;

import com.adidyk.model.OrderSmartPhone;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class SmartPhone.
 */
@Entity
@Table(name = "products")
public class Product {

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

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "type_id")
    private Type type;

    /*
    /**
     * @param orderSmartPhones - order smart phones.
     */
    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "smartPhone")
    @Fetch(FetchMode.JOIN)
    private List<OrderSmartPhone> orderSmartPhones = new ArrayList<>();
    */

    /**
     * SmartPhone - constructor.
     */
    public Product() {
    }

    /**
     * SmartPhone - constructor.
     * @param id - id.
     */
    public Product(int id) {
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
    public Product(int id, String company, String model, String description, int quantity, double price, Type type) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    /**
     * SmartPhone - constructor.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price by one.
     */
    public Product(int id, String company, String model, String description, int quantity, double price) {
        this.id = id;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(company, product.company) &&
                Objects.equals(model, product.model) &&
                Objects.equals(description, product.description) &&
                Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, model, description, quantity, price, type);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}