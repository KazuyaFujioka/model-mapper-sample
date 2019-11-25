package com.example.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovieFactory {
    public static Movie create() {
        Title title = new Title("【字幕】アナと雪の女王２");
        Price price = new Price(BigDecimal.valueOf(1500));
        DateOfRelease release = new DateOfRelease(LocalDate.of(2019, 11, 22));
        return new Movie(title, price, release);
    }
}
