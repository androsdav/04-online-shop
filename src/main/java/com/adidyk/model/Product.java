package com.adidyk.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.Objects;

/**
 * Class Product.
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
     * @param type - type product.
     */
    @Column(name = "type")
    private String type;

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
     * @param order - order.
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     *
     * @param type - type.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price.
     * @param order - order.
     */
    public Product(String type, String company, String model, String description, int quantity, double price, Order order) {
        this.type = type;
        this.company = company;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                quantity == product.quantity &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(type, product.type) &&
                Objects.equals(company, product.company) &&
                Objects.equals(model, product.model) &&
                Objects.equals(description, product.description) &&
                Objects.equals(order, product.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, company, model, description, quantity, price, order);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + order +
                '}';
    }
}
