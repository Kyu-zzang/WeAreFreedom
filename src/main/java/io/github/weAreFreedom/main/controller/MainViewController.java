package io.github.weAreFreedom.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainViewController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}