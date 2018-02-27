package com.domaina.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GreetingController {

    @RequestMapping("/index")
    public String greeting(HttpServletResponse response, Model model) {
        model.addAttribute("name", "CORS");
        return "index";
    }
}