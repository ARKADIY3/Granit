package org.example.prostorazvlecaus.service.impl;


import org.example.prostorazvlecaus.model.Service;
import org.example.prostorazvlecaus.repo.ServiceRepo;
import org.example.prostorazvlecaus.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class implServices implements ServiceService {

    private final ServiceRepo servicerepo;

    public implServices(ServiceRepo servicerepo) {
        this.servicerepo = servicerepo;
    }

    @Override
    public void addService(Service service) {
        servicerepo.save(service);
    }

    @Override
    public void deleteService(Long id){
        servicerepo.deleteById(id);
    }

    @Override
    public List<Service> getAllServices() {
        return servicerepo.findAll();
    }

    @Override
    public Service getServiceById(Long id) {
        return servicerepo.findById(id).orElse(null);
    }
}
