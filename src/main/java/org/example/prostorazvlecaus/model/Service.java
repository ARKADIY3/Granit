package org.example.prostorazvlecaus.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String serviceType;

    @OneToMany(mappedBy = "service")
    private List<Order> orders;

    public Service() {
    }

    public Service(Long id, String name, String serviceType) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
    }

    public Long getId() {
        return id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceTypeDisplayName() {
        if (serviceType == null) return "";
        try {
            return org.example.prostorazvlecaus.model.ServiceType.valueOf(serviceType).getDisplayName();
        } catch (Exception e) {
            return serviceType;
        }
    }
}
