package org.example.prostorazvlecaus.repo;

import org.example.prostorazvlecaus.model.Stone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StonesRepo extends JpaRepository<Stone, Long> {}
