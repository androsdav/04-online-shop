package com.adidyk.model.dto;

import com.adidyk.model.pojo.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDTO {

    /**
     * @param id - order id.
     */
    private int id;

    /**
     * @param dateCreate - date create of order.
     */
    private Date dateCreate = new Date();

    /**
     * @param user - user.
     */
    private UserDTO user;

    /**
     * @param orderSmartPhones - order smart phones.
     */
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(int id, UserDTO user,  List<ProductDTO> products) {
        this.id = id;
        this.user = user;
        this.products = products;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(dateCreate, orderDTO.dateCreate) &&
                Objects.equals(user, orderDTO.user) &&
                Objects.equals(products, orderDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCreate, user, products);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
