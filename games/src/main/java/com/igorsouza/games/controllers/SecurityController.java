package com.igorsouza.games.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {
        return "access-denied";
    }
}
