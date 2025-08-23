package com.design.URL_shortener.api;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

    @Autowired
    private URLService urlService;

    URLController() {
        // do nothing for now
    }

    @GetMapping("hello")
    public String testApi() {
        return "Welcome to the api";
    }

    @PostMapping("/shorten")
    public String shorten(@RequestParam String url) {
        System.out.println("Inside shorten");
        System.out.println(url);
            return this.urlService.shorten(url);
    }
}
