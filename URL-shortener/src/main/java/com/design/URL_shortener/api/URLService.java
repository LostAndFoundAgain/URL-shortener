package com.design.URL_shortener.api;

import com.design.URL_shortener.Model.Counter;
import com.design.URL_shortener.Model.URL;
import com.design.URL_shortener.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Autowired
    MongoTemplate mongoTemplate;

    URLService() {
    }

    private long getCounter() {
        Query query = new Query(Criteria.where("_id").is("url-seq"));
        Update update = new Update().inc("counter", 1);
        Counter counter = this.mongoTemplate.findAndModify(
                query,
                update,
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Counter.class);
        return counter.getCounter();
    }

    private String convertDecimalToBase62(long number) {
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            int remainder = (int) (number % 62);
            encoded.append(Constants.base62.charAt(remainder));
            number = number / 62;
        }
        encoded.reverse();
        return encoded.toString();
    }

    private void saveShortUrl(String shortUrl, String longUrl, long counter) {
        URL url = new URL(shortUrl, longUrl, counter);
        this.mongoTemplate.save(url, "short-url");
    }

    public String shorten(String url) {
        long incrementId = this.getCounter();
        String shortUrl = Constants.TINYURL + "/" + this.convertDecimalToBase62(incrementId);
        this.saveShortUrl(shortUrl, url, incrementId);
        return shortUrl;
    }
}
