package com.lzq.Model;

import com.lzq.pojo.User;
import lombok.Builder;
import lombok.Data;

public interface InvalidUserResult {

    @Builder
    @Data
    class Result {

        public boolean isSuccess;

        private User user;
    }


}
