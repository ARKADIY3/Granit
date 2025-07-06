package org.example.prostorazvlecaus.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String client;
    private String weight;
    private String totalPrice;
    private Date OrderCreationDate;

    @ManyToOne
    @JoinColumn(name = "stone_id")
    private Stone stone;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;


    public Order() {
    }

    public Order(Long id, String client, String weight, String totalPrice, Date orderCreationDate) {
        this.id = id;
        this.client = client;
        this.weight = weight;
        this.totalPrice = totalPrice;
        OrderCreationDate = orderCreationDate;}

    public Stone getStone() {
        return stone;
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String toralPrice) {
        this.totalPrice = toralPrice;
    }

    public Date getOrderCreationDate() {
        return OrderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        OrderCreationDate = orderCreationDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
