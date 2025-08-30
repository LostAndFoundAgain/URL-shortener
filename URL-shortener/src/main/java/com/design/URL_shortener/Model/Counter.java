package com.design.URL_shortener.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.design.URL_shortener.constants.Constants.COUNTER_COLLECTION;

@Document(collection = COUNTER_COLLECTION)
public class Counter {
    @Id
    String name = "url-seq";
    int counter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
