package org.example.prostorazvlecaus.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stone")
public class Stone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firmnessToMohs; /* твёрдость по Моосу */
    private String density;  /* плотность */
    private String color;
    private String typeOfStone; /* тип камня */

    @OneToMany(mappedBy = "stone")
    private List<Order> orders;

    public Stone() {}

    public Stone(Long id, String name, String firmnessToMohs, String density, String color, String typeOfStone) {
        this.id = id;
        this.name = name;
        this.firmnessToMohs = firmnessToMohs;
        this.density = density;
        this.color = color;
        this.typeOfStone = typeOfStone;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirmnessToMohs() {
        return firmnessToMohs;
    }
    public void setFirmnessToMohs(String firmnessToMohs) {
        this.firmnessToMohs = firmnessToMohs;
    }
    public String getDensity() {
        return density;
    }
    public void setDensity(String density) {
        this.density = density;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTypeOfStone() {
        return typeOfStone;
    }
    public void setTypeOfStone(String typeOfStone) {
        this.typeOfStone = typeOfStone;
    }
}
