package com.adidyk.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Type.
 */
@Entity
@Table (name = "types")
public class Type {

    /**
     * @param id - id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Param name - name.
     */
    @Column(name = "name")
    private String name;

    /**
     * @param products - products.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "type")
    @Fetch(FetchMode.JOIN)
    private List<Product> products = new ArrayList<>();

    /**
     * Type - constructor.
     */
    public Type() {
    }

    /**
     * Type - constructor.
     * @param name - name.
     */
    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Type - constructor.
     * @param name - name.
     * @param products - products.
     */
    public Type(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type type = (Type) o;
        return Objects.equals(name, type.name) &&
                Objects.equals(products, type.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name=" + name +
                ", products=" + products +
                '}';
    }

}