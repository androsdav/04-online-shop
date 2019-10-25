package com.adidyk.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;

/**
 * Class OrderSmartPhone.
 */
@Entity
@Table(name = "order_smart_phone")
public class OrderSmartPhone {

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
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Column(name = "order_id")
    private Order order;

    /**
     * @param smartPhone - smart phone.
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Column(name = "smart_phone_id")
    private SmartPhone smartPhone;

}
