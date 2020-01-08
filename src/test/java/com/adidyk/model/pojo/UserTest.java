package com.adidyk.model.pojo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class UserTest used for testing methods of class User.
 *  @author Didyk Andrey (androsdav@gmail.com).
 *  @since 03.01.2020.
 *  @version 1.0.
 */
public class UserTest {

    /**
     * @param userExpected - user.
     */
    private final User userExpected = new User(1, "man", "111", "bob", "dilan", 222);

    /**
     * @param listExpected - list orders.
     */
    private List<Order> listExpected = new ArrayList<>();

    /**
     * @param userActual - user.
     */
    private final User userActual = new User(1, "man", "111", "bob", "dilan", 222);

    /**
     * @param listActual - list orders.
     */
    private List<Order> listActual = new ArrayList<>();

    /**
     * init - inits params.
     */
    @Before
    public void init() {
        Order order1 = new Order();
        Date date = new Date();
        order1.setDateCreate(date);
        Order order2 = new Order();
        order2.setDateCreate(date);
        Order order3 = new Order();
        order3.setDateCreate(date);
        Order order4 = new Order();
        order4.setDateCreate(date);
        this.listExpected.add(order1);
        this.listExpected.add(order2);
        this.listActual.add(order3);
        this.listActual.add(order4);
        this.userExpected.setOrders(this.listExpected);
        this.userActual.setOrders(this.listActual);
    }

    /**
     * getIdTest - tests method getId.
     */
    @Test
    public void getIdTest() {
        assertThat(1, is(this.userExpected.getId()));
    }

    /**
     * setIdTest - tests method setId.
     */
    @Test
    public void setIdTest() {
        this.userExpected.setId(2);
        assertThat(2, is(this.userExpected.getId()));
    }

    /**
     * getLoginTest - tests method getLogin.
     */
    @Test
    public void getLoginTest() {
        assertThat("man", is(userExpected.getLogin()));
    }

    /**
     * setLoginTest - tests method setLogin.
     */
    @Test
    public void setLoginTest() {
        this.userExpected.setLogin("woman");
        assertThat("woman", is(userExpected.getLogin()));
    }

    /**
     * getPasswordTest - test method getPassword.
     */
    @Test
    public void getPasswordTest() {
        assertThat("111", is(this.userExpected.getPassword()));
    }

    /**
     * setPasswordTest - tests method setPassword.
     */
    @Test
    public void setPasswordTest() {
        this.userExpected.setPassword("123");
        assertThat("123", is(this.userExpected.getPassword()));
    }

    /**
     * getFirstNameTest - tests getFirstName.
     */
    @Test
    public void getFirstNameTest() {
        assertThat("bob", is(this.userExpected.getFirstName()));
    }

    /**
     * setFirstNameTest - tests method setsFirstName.
     */
    @Test
    public void setFirstNameTest() {
        this.userExpected.setFirstName("billy");
        assertThat("billy", is(this.userExpected.getFirstName()));
    }

    /**
     * getSecondNameTest - test getSecondName.
     */
    @Test
    public void getSecondNameTest() {
        assertThat("dilan", is(this.userExpected.getSecondName()));
    }

    /**
     * setSecondNameTest - test method setSecondName.
     */
    @Test
    public void setSecondNameTest() {
        this.userExpected.setSecondName("bobby");
        assertThat("bobby", is(this.userExpected.getSecondName()));
    }

    /**
     * getPhoneNumberTest - tests method getPhoneNumber.
     */
    @Test
    public void getPhoneNumberTest() {
        assertThat(222, is(this.userExpected.getPhoneNumber()));
    }

    /**
     * setPhoneNumberTest - tests method setPhoneNumber.
     */
    @Test
    public void setPhoneNumber() {
        this.userExpected.setPhoneNumber(333);
        assertThat(333, is(this.userExpected.getPhoneNumber()));
    }

    @Test
    public void getOrders() {
        System.out.println(this.userActual.getOrders());
        System.out.println(this.userExpected.getOrders());
        assertThat(this.userActual.getOrders(), is(this.userExpected.getOrders()));
    }

    @Test
    public void setOrders() {
    }

    /**
     * equalsTest - test method equals.
     */
    @Test
    public void equalsTest() {
        assertThat(this.userActual, is(this.userExpected));
    }

    /**
     * hashCodeTest - test method hashCode.
     */
    @Test
    public void hashCodeTest() {
        assertThat(this.userActual.hashCode(), is(this.userExpected.hashCode()));
    }

    /**
     * toStringTest - test method toString.
     */
    @Test
    public void toStringTest() {
        assertThat(this.userActual.toString(), is(this.userExpected.toString()));

    }

}