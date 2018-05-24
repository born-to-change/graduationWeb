package com.lzq.Model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.codehaus.jackson.annotate.JsonProperty;

public interface UserInfo {
    @Data
    @Builder
    class Arg {
        @JSONField(name = "telephone")
        @SerializedName(value = "telephone")
        @JsonProperty(value = "telephone")
        private String telephone;

        @JSONField(name = "user_password")
        @SerializedName(value = "user_password")
        @JsonProperty(value = "user_password")
        private String userPassword;

        @JSONField(name = "user_token")
        @SerializedName(value = "user_token")
        @JsonProperty(value = "user_token")
        private String userToken;

        @JSONField(name = "user_id")
        @SerializedName(value = "user_id")
        @JsonProperty(value = "user_id")
        private Integer userId;

        @JSONField(name = "user_label")
        @SerializedName(value = "user_label")
        @JsonProperty(value = "user_label")
        private String userLabel;

        @JSONField(name = "address")
        @SerializedName(value = "address")
        @JsonProperty(value = "address")
        private String address;

        @JSONField(name = "user_image")
        @SerializedName(value = "user_image")
        @JsonProperty(value = "user_image")
        private String userImage;

    }

    @Builder
    @Data
    class Result {
        public String errorMessage;

        public boolean isSuccess;
    }
}
