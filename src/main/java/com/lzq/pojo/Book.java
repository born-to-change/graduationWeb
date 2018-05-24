package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Book {
    @NonNull
    private String bookId;
    @NonNull
    private String bookName;
    @NonNull
    private String bookImage;
    @NonNull
    private String bookPress;
    @NonNull
    private Integer userId;
    @NonNull
    private BigDecimal price;

    private String bookDescription;
}
