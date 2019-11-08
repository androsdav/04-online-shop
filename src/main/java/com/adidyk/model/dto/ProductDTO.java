package com.adidyk.model.dto;

import com.adidyk.model.pojo.Type;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

public class ProductDTO {

    /**
     * @param id - id.
     */
    private int id;

    /**
     * @param company - company.
     */
    private String company;

    /**
     * @param model - model.
     */
    private String model;

    /**
     * @param description.
     */
    private String description;

    /**
     * @param quantity - quantity.
     */
    private int quantity;

    /**
     * @param price - price.
     */
    private double price;

    /**
     * @param type - type.
     */
    private TypeDTO type;

    public ProductDTO() {

    }

    /**
     * ProductDTO - constructor.
     * @param id - id.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price.
     */
    public ProductDTO(int id, String company, String model, String description, int quantity, double price) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * ProductDTO - constructor.
     * @param id - id.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price.
     * @param type - type.
     */
    public ProductDTO(int id, String company, String model, String description, int quantity, double price, TypeDTO type) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
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

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO that = (ProductDTO) o;
        return quantity == that.quantity &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(company, that.company) &&
                Objects.equals(model, that.model) &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, model, description, quantity, price, type);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}