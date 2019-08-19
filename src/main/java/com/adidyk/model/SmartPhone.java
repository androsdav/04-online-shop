package com.adidyk.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class SmartPhone.
 */
@Entity
@Table(name = "smart_phone")
public class SmartPhone {

    /**
     * @param id - id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param company - company.
     */
    @Column(name = "company")
    private String company;

    /**
     * @param model - model.
     */
    @Column(name = "model")
    private String model;

    /**
     * @param description.
     */
    @Column(name = "description")
    private String description;

    /**
     * SmartPhone - constructor.
     */
    public SmartPhone() {
    }

    /**
     * SmartPhone - constructor.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     */
    public SmartPhone(String company, String model, String description) {
        this.company = company;
        this.model = model;
        this.description = description;
    }

    /**
     * SmartPhone - constructor.
     * @param id - id.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     */
    public SmartPhone(int id, String company, String model, String description) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartPhone that = (SmartPhone) o;
        return id == that.id &&
                Objects.equals(company, that.company) &&
                Objects.equals(model, that.model) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, model, description);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}