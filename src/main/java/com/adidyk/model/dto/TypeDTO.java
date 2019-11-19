package com.adidyk.model.dto;

import java.util.List;
import java.util.Objects;

public class TypeDTO {

    private int id;

    private String name;

    public TypeDTO() {
    }

    public TypeDTO(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeDTO)) return false;
        TypeDTO typeDTO = (TypeDTO) o;
        return Objects.equals(name, typeDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
