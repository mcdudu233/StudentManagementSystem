package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.User;
import top.mcso.sms.mapper.UserMapper;
import top.mcso.sms.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insertUser(User user) {
        try {
            return userMapper.insertUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting user", e);
        }
    }

    @Override
    public boolean deleteUserByUserNumber(String userNumber) {
        try {
            return userMapper.deleteByUserNumber(userNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user by user number", e);
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            return userMapper.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    @Override
    public User findUserByUserNumber(String userNumber) {
        try {
            return userMapper.getByUserNumber(userNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error finding user by user number", e);
        }
    }

    @Override
    public List<User> findAllUsers() {
        try {
            return userMapper.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error finding all users", e);
        }
    }


}

