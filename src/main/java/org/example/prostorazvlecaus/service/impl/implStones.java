package org.example.prostorazvlecaus.service.impl;

import org.example.prostorazvlecaus.model.Stone;
import org.example.prostorazvlecaus.repo.StonesRepo;
import org.example.prostorazvlecaus.service.StonesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class implStones implements StonesService {

    private final StonesRepo stonesRepo;

    public implStones(StonesRepo stonesRepo) {
        this.stonesRepo = stonesRepo;
    }

    @Override
    public List<Stone> getAllStones(){
        return stonesRepo.findAll();
    }

    @Override
    public void saveStones(Stone stones){
        stonesRepo.save(stones);
    }

    @Override
    public void deleteStones(Long id){
        stonesRepo.deleteById(id);
    }

    @Override
    public Stone getStones(Long id){
        return stonesRepo.findById(id).orElse(null);
    }
}
