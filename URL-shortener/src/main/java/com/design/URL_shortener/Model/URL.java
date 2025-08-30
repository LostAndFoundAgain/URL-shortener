package com.design.URL_shortener.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import static com.design.URL_shortener.constants.Constants.SHORT_URL_COLLECTION;

@Document(collection = SHORT_URL_COLLECTION)
public class URL {
    String shortUrl;
    String longUrl;
    long counter;
    @CreatedDate
    Date createdAt;

    public URL(String shortUrl, String longUrl, long counter) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.counter = counter;
    }


    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
