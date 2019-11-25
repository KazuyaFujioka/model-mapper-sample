package com.example.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

class MovieView {

    @JsonProperty("title")
    String titleValue;

    @JsonProperty("price")
    BigDecimal priceValue;

    @JsonProperty("release")
    LocalDate releaseValue;

    MovieView(String titleValue, BigDecimal priceValue, LocalDate releaseValue) {
        this.titleValue = titleValue;
        this.priceValue = priceValue;
        this.releaseValue = releaseValue;
    }

    @Override
    public String toString() {
        return "MovieView{" +
                "title='" + titleValue + '\'' +
                ", price=" + priceValue +
                ", release=" + releaseValue +
                '}';
    }

    MovieView() {
    }
}
