package com.lzq.service;

import com.lzq.common.Resullt;
import com.lzq.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    Resullt.Result createUser(User user);

    Resullt.Result updateUser(User user);

    Resullt.Result deleteUser(int userId);

    User getUserById(int userId);

    User getUserByUserLabel(String userLabel);

}
