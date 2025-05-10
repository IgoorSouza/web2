package com.igorsouza.games.controllers;

import com.igorsouza.games.models.User;
import com.igorsouza.games.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/register")
    public String register() {
        return "users/register";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model) {
        UUID userId = usersService.saveUser(user);
        String message = "User " + userId + " successfully registered!";
        model.addAttribute ("msg", message) ;
        return "users/register";
    }
}
