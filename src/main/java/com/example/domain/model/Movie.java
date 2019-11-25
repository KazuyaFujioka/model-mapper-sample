package com.example.domain.model;

public class Movie {

    Title title;
    Price price;
    DateOfRelease release;

    Movie(Title title, Price price, DateOfRelease release) {
        this.title = title;
        this.price = price;
        this.release = release;
    }

    Movie() {
    }
}
