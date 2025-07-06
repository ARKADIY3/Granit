package org.example.prostorazvlecaus.controller;

import org.example.prostorazvlecaus.model.Service;
import org.example.prostorazvlecaus.service.ServiceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/service")
public class ServiceControllers {

    private final ServiceService serviceService;

    public ServiceControllers(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/listService")
    public String listService(Model model , Service service) {
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("services" , services);
        return "service/listService";
    }

    @GetMapping("/newService")
    public String newService(Model model , Service service) {
        model.addAttribute("service", new Service());
        return "service/newService";
    }

    @PostMapping("/saveService")
    public String addService(@ModelAttribute Service service) {
        serviceService.addService(service);
        return "redirect:/service/listService";
    }

    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id){
        serviceService.deleteService(id);
        return "redirect:/service/listService";
    }

    @GetMapping("/create/{id}")
    public String createService(@PathVariable Long id, Model model) {
        Service service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        return "service/createService";
    }

    @PostMapping("/create/{id}")
    public String createService(@ModelAttribute Service service, @PathVariable Long id) {
        service.setId(id);
        serviceService.addService(service);
        return "redirect:/service/listService";
    }
}
