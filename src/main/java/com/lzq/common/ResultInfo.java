package com.lzq.common;

import lombok.Builder;
import lombok.Data;

public interface ResultInfo {
    @Builder
    @Data
    class Result {
        public String errorMessage;

        public boolean isFailed;
    }

}
