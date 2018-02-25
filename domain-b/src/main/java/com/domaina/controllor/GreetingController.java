package com.domaina.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {

    @RequestMapping("/test1")
    @ResponseBody
    public Map<String, String> index(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "this is from domain b");
        return map;
    }

    @RequestMapping("/jsonpCall")
    @ResponseBody
    public Map<String, String> jsonpCall(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "this is from domain b");
        return map;
    }
}