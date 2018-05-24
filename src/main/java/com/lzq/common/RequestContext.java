package com.lzq.common;


import com.lzq.pojo.User;
import lombok.Builder;
import lombok.Getter;
import java.util.Optional;

@Builder
@Getter
public class RequestContext {
    /**
     * 请求上下文中的认证用户，不是所有请求中都有认证用户
     */
    private final Optional<User> user;


}
