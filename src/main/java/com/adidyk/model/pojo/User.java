package com.adidyk.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class User.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * @param id - order id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param login - login.
     */
    @Column(name = "login")
    private String login;

    /**
     * @param password - password.
     */
    @Column(name = "password")
    private String password;

    /**
     * @param firstName - user first name.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * @param secondName - user second name.
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * @param phoneNumber - user phone number.
     */
    @Column(name = "phone_number")
    private int phoneNumber;

    /**
     * @param orders - list orders.
     */
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    /**
     * User - constructor.
     */
    public User() {
    }

    /**
     * User - constructor.
     * @param login - login.
     * @param password - password.
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * User - constructor.
     * @param login - login.
     * @param password - password.
     * @param firstName - user first name.
     * @param secondName - user second name.
     * @param phoneNumber - user phone number.
     */
    public User(int id, String login, String password, String firstName, String secondName, int phoneNumber) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * User - constructor.
     * @param firstName - user first name.
     * @param secondName - user second name.
     * @param phoneNumber - user phone number.
     * @param orders - list orders.
     */
    public User(String firstName, String secondName, int phoneNumber, ArrayList<Order> orders) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    /**
     * User - constructor.
     * @param id - id.
     */
    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                phoneNumber == user.phoneNumber &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, secondName, phoneNumber, orders);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber=" + phoneNumber +
                //", orders=" + orders +
                '}';
    }
}