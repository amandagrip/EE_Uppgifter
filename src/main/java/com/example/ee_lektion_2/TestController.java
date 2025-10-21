package com.example.ee_lektion_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String returnString() {
        return "Home.html";
    }
}
