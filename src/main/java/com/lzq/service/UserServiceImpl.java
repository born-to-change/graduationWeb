package com.lzq.service;

import com.lzq.common.Resullt;
import com.lzq.mapper.UserMapper;
import com.lzq.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Resullt.Result createUser(User user) {
        Resullt.Result ret = Resullt.Result.builder().isFailed(true).build();
        try {
            userMapper.createUser(user);

        } catch (Exception e) {
            log.warn("create user failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public Resullt.Result updateUser(User user) {
        Resullt.Result ret = Resullt.Result.builder().isFailed(true).build();
        try {
            userMapper.updateUser(user);

        } catch (Exception e) {
            log.warn("update user failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public Resullt.Result deleteUser(int userId) {
        Resullt.Result ret = Resullt.Result.builder().isFailed(true).build();
        try {
            userMapper.deleteUser(userId);

        } catch (Exception e) {
            log.warn("update user failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public User getUserById(int userId) {
        User user;
        try {
            user = userMapper.getUserById(userId);

        } catch (Exception e) {
            log.warn("get user by userId failed", e);
            return null;
        }
        return user;

    }

    public User getUserByUserLabel(String userLabel){
        User user;
        try {
            user = userMapper.getUserByUserLabel(userLabel);

        } catch (Exception e) {
            log.warn("get user by userLabel failed", e);
            return null;
        }
        return user;
    }
}