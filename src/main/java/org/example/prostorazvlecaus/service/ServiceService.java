package org.example.prostorazvlecaus.service;

import org.example.prostorazvlecaus.model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> getAllServices();
    void addService(Service service);
    void deleteService(Long id);
    Service getServiceById(Long id);
}
