package com.adidyk.models;

import java.util.Objects;

/**
 * Class User.
 */
public class User {

    private int user_id;

    private String firstName;

    private String lastName;

    public User() {
    }

    public User(int id, String firstName, String lastName) {
        this.user_id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return user_id;
    }


    public void setId(int id) {
        this.user_id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}