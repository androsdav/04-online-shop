package com.adidyk.model.dto;

import javax.persistence.*;
import java.util.Objects;

public class OrderProductDTO {


    /**
     * @param id - id.
     */
    private int id;

    /**
     * @param order - order.
     */
    private OrderDTO order;

    /**
     * @param smartPhone - smart phone.
     */
    private ProductDTO product;

    /**
     * @param count - count.
     */
    @Column(name = "count")
    private int count;

    public OrderProductDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProductDTO)) return false;
        OrderProductDTO that = (OrderProductDTO) o;
        return count == that.count &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product, count);
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                //", order=" + order +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}
