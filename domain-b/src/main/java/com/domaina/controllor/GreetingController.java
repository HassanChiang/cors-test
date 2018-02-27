package com.domaina.controllor;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {

    @RequestMapping("/test1")
    @ResponseBody
    public Map<String, String> index(HttpServletResponse response, Model model) {
        response.addCookie(new Cookie("c1", "testCookie"));
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

    @RequestMapping("/test2WithHeader")
    @ResponseBody
    public Map<String, String> test2WithHeader(HttpServletResponse response, Model model) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.addHeader("Access-Control-Allow-Methods", "GET");
        Map<String, String> map = new HashMap<>();
        map.put("msg", "this is from domain b");
        return map;
    }

    @RequestMapping("/test3WithHeader")
    @ResponseBody
    public Map<String, String> test3WithHeader(HttpServletResponse response, Model model) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        Map<String, String> map = new HashMap<>();
        map.put("msg", "this is from domain b");
        return map;
    }

    @PostMapping("/testPreflighted")
    @ResponseBody
    public Map<String, String> testPreflighted(HttpServletResponse response, @RequestBody String body) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", body);
        return map;
    }

    @PostMapping("/testPreflighted2")
    @ResponseBody
    public Map<String, String> testPreflighted2(HttpServletResponse response, @RequestBody String body) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", (String) JSON.parseObject(body).get("msg"));
        return map;
    }

    @RequestMapping("/testCookie1")
    @ResponseBody
    public Map<String, String> testCookie1(HttpServletResponse response,
                                           @CookieValue("c1") String c1) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        Map<String, String> map = new HashMap<>();
        map.put("msg", c1);
        return map;
    }

    @RequestMapping("/testCookie2")
    @ResponseBody
    public Map<String, String> testCookie2(HttpServletRequest request,
                                           HttpServletResponse response,
                                           @CookieValue("c1") String c1) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.addHeader("Access-Control-Allow-Methods", "*");
//        response.addHeader("Access-Control-Allow-Credentials", "true");
//
//        String origin = request.getHeader("Origin");
//        if(!StringUtils.isEmpty(origin)){
//            response.addHeader("Access-Control-Allow-Origin", origin);
//        }

        Map<String, String> map = new HashMap<>();
        map.put("msg", c1);
        return map;
    }

    @RequestMapping("/testHeader1")
    @ResponseBody
    public Map<String, String> testHeader1(HttpServletRequest request,
                                           HttpServletResponse response,
                                           @RequestHeader("testHeader") String testHeader) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", testHeader);
        return map;
    }
}