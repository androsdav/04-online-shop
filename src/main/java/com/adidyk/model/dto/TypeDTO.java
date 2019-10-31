package com.adidyk.model.dto;

import com.adidyk.model.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TypeDTO {

    private int id;

    private String name;

    private List<ProductDTO> products = new ArrayList<>();

    public TypeDTO() {
    }

    public TypeDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeDTO(int id, String name, List<ProductDTO> products) {
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeDTO)) return false;
        TypeDTO typeDTO = (TypeDTO) o;
        return name == typeDTO.name &&
                Objects.equals(products, typeDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "id=" + id +
                ", name=" + name +
                ", products=" + products +
                '}';
    }
}
