package org.example.prostorazvlecaus.controller;

import org.example.prostorazvlecaus.model.Order;
import org.example.prostorazvlecaus.model.Service;
import org.example.prostorazvlecaus.model.Stone;
import org.example.prostorazvlecaus.service.OrderService;
import org.example.prostorazvlecaus.service.ServiceService;
import org.example.prostorazvlecaus.service.StonesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/order")
public class OrderControllers {

    private final OrderService orderService;
    private final StonesService stonesService;
    private final ServiceService serviceService;

    public OrderControllers(OrderService orderService , StonesService stonesService , ServiceService serviceService) {
        this.orderService = orderService;
        this.stonesService = stonesService;
        this.serviceService = serviceService;
    }

    @GetMapping("/listOrder")
    public String listOrder(Model model , Order order ,Stone stone , Service service) {
        List<Order> orders = orderService.getOrder();
        model.addAttribute("orders" , orders);
        model.addAttribute("stone" , stone);
        model.addAttribute("service" , service);
        return "/order/listOrder";
    }

    @GetMapping("/newOrder")
    public String newOrder(Model model, Order order) {
        model.addAttribute("order", order);
        List<Stone> stones = stonesService.getAllStones();
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("allServices", services);
        model.addAttribute("allStones", stones);
        return "/order/newOrder";
    }

    @PostMapping("/saveOrder")
    public String addOrder(@ModelAttribute Order order) {
        orderService.addOrder(order);
        return "redirect:/order/listOrder";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/order/listOrder";
    }

    @GetMapping("/create/{id}")
    public String createOrder(@PathVariable Long id, Model model) {
        Order order = orderService.getOrder(id);
        model.addAttribute("order", order);
        model.addAttribute("allServices", serviceService.getAllServices());
        model.addAttribute("allStones", stonesService.getAllStones());
        return "/order/createOrder";
    }

    @PostMapping("/create/{id}")
    public String createOrder(@ModelAttribute Order order, @PathVariable Long id) {
        order.setId(id);
        orderService.addOrder(order);
        return "redirect:/order/listOrder";
    }
}
