package com.lzq.Model;

import lombok.Builder;
import lombok.Data;

public interface InvalidUserResult {

    @Builder
    @Data
    class Result {
        public String errorMessage;

        public boolean isFailed;
    }


}
