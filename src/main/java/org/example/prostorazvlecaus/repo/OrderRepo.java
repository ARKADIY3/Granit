package org.example.prostorazvlecaus.repo;

import org.example.prostorazvlecaus.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {}
