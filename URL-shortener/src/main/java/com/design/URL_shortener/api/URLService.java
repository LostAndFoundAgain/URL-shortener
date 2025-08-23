package com.design.URL_shortener.api;

import com.design.URL_shortener.constants.Constants;
import org.springframework.stereotype.Service;

@Service
public class URLService {
    URLService() {
        // do nothing
    }

    private String convertDecimalToBase62(int number) {
        StringBuilder encoded = new StringBuilder();
        while(number > 0) {
            int remainder = number%62;
            encoded.append(Constants.base62.charAt(remainder));
            number = number/62;
        }
        encoded.reverse();
        System.out.println(encoded);
        return encoded.toString();
    }

    public String shorten(String url) {
        int incrementId = Constants.increment + 1;
        Constants.increment  = Constants.increment + 1;
        System.out.println(incrementId);
        return this.convertDecimalToBase62(incrementId);
    }
}
