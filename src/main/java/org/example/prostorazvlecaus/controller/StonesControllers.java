package org.example.prostorazvlecaus.controller;

import org.example.prostorazvlecaus.model.Stone;
import org.example.prostorazvlecaus.service.StonesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stone")
@PreAuthorize("hasRole('ADMIN')")
public class StonesControllers {

    public final StonesService stonesService;

    public StonesControllers(StonesService stonesService) {
        this.stonesService = stonesService;
    }

    @GetMapping("/list")
    public String listStones(Model model , Stone stone){
        List<Stone> stones = stonesService.getAllStones();
        model.addAttribute("stones", stones);
        return "/stone/list";
    }

    @GetMapping("/new")
    public String newStone(Model model , Stone stone){
        model.addAttribute("stone", new Stone());
        return "/stone/newStone";
    }

    @PostMapping("/save")
    public String saveStone(@ModelAttribute Stone stone){
        stonesService.saveStones(stone);
        return "redirect:/stone/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStone(@PathVariable Long id){
        stonesService.deleteStones(id);
        return "redirect:/stone/list";
    }

    @GetMapping("/create/{id}")
    public String editStoneForm(@PathVariable Long id, Model model) {
        model.addAttribute("stone", stonesService.getStones(id));
        return "/stone/createStone";
    }

    @PostMapping("/create/{id}")
    public String createStone(@ModelAttribute Stone stone, @PathVariable Long id) {
        stone.setId(id);
        stonesService.saveStones(stone);
        return "redirect:/stone/list";
    }
}
