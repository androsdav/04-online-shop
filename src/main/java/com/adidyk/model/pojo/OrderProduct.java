package com.adidyk.model.pojo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.Objects;

/**
 * Class OrderSmartPhone.
 */
@Entity
@Table(name = "orders_products")
public class OrderProduct {

    /**
     * @param id - id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param order - order.
     */
    @ManyToOne(optional = false)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * @param smartPhone - smart phone.
     */
    @ManyToOne(optional = false)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * @param count - count.
     */
    @Column(name = "count")
    private int count;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int count) {
        this.order = order;
        this.product = product;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
        if (!(o instanceof OrderProduct)) return false;
        OrderProduct that = (OrderProduct) o;
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
