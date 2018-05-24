package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class User {
    @NonNull
    private String telephone;
    @NonNull
    private String userPassword;
    @NonNull
    private String userToken;

    private Integer userId;

    private String userLabel;
    private String address;
    private String userImage;
}