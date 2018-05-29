package com.lzq.mapper;

import com.lzq.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void createUser(User user);

    void updateUser(User user);

    boolean deleteUser(int userId);

    User getUserById(int userId);

    User getUserByUserLabel(String userLabel);
}