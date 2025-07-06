package org.example.prostorazvlecaus.controller;

import org.example.prostorazvlecaus.model.User;
import org.example.prostorazvlecaus.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserControllers {

    public final UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listUser")
    public String listUser(Model model , User user){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/user/listUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/user/listUser";
    }

    @GetMapping("/search")
    public String searchUser(@RequestParam String searchTerm, Model model) {
        List<User> users = userService.searchUser(searchTerm);
        model.addAttribute("users", users);
        return "user/listUser";
    }
}
