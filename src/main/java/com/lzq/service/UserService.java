package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    ResultInfo.Result createUser(User user);

    ResultInfo.Result updateUser(User user);

    ResultInfo.Result deleteUser(int userId);

    User getUserById(int userId);

    User getUserByUserLabel(String userLabel);

}
