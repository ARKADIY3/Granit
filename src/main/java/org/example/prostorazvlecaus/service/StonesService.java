package org.example.prostorazvlecaus.service;


import org.example.prostorazvlecaus.model.Stone;

import java.util.List;

public interface StonesService {
    List<Stone> getAllStones();
    void saveStones(Stone stones);
    void deleteStones(Long id);
    Stone getStones(Long id);
}
