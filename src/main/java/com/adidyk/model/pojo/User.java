package com.adidyk.model.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class User used for creates new object user with params: id, login, password, first name, second name.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.01.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * @param id - user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param login - user login.
     */
    @Column(name = "login")
    private String login;

    /**
     * @param password - user password.
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
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    /**
     * User - constructor.
     */
    public User() {
    }

    /**
     * User - constructor.
     * @param id - user id.
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * User - constructor.
     * @param login - user login.
     * @param password - user password.
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * User - constructor.
     * @param login - user login.
     * @param password - user password.
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
     * getId - returns user id.
     * @return - returns user id.
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets user id.
     * @param id - user id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getLogin - returns user login.
     * @return - returns ser login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * setLogin - sets user login.
     * @param login - user login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * getPassword - returns user password.
     * @return - returns user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword - sets user password.
     * @param password - user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getFirstName - returns user first name.
     * @return - returns user first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName - sets user first name.
     * @param firstName - user first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getSecondName - returns user second name.
     * @return - returns user second name.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * setSecondName - sets user second name.
     * @param secondName - user second name.
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * getPhoneNumber - returns user phone number.
     * @return - returns user phone number.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * setPhoneNumber - sets user phone number.
     * @param phoneNumber - user phone number.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getOrder - returns all orders (list orders) for user.
     * @return - returns all orders (list orders) for user.
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * setOrder - sets list orders for user.
     * @param orders - list orders.
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * equals - returns boolean result.
     * @param o - object of class Object.
     * @return - returns "true" if id, phone number, login, password, first name, second name, orders of user is same,
     * and returns "false" - isn`t same.
     */
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

    /**
     * hashCode - returns hash code for user.
     * @return - returns hash code for user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, secondName, phoneNumber, orders);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

}