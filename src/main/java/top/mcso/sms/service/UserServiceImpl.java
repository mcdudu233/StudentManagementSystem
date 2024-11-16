package top.mcso.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.User;
import top.mcso.sms.mapper.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        try {
            return userMapper.insert(user);
        } catch (Exception e) {
            throw new ServiceException("Error inserting user", e);
        }
    }

    @Override
    public int deleteUserByUserNumber(String userNumber) {
        try {
            return userMapper.deleteByUserNumber(userNumber);
        } catch (Exception e) {
            throw new ServiceException("Error deleting user by user number", e);
        }
    }

    @Override
    public int updateUser(User user) {
        try {
            return userMapper.update(user);
        } catch (Exception e) {
            throw new ServiceException("Error updating user", e);
        }
    }

    @Override
    public User findUserByUserNumber(String userNumber) {
        try {
            return userMapper.findByUserNumber(userNumber);
        } catch (Exception e) {
            throw new ServiceException("Error finding user by user number", e);
        }
    }

    @Override
    public List<User> findAllUsers() {
        try {
            return userMapper.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error finding all users", e);
        }
    }

    @Override
    public User findUserByUsername(String username) {
        try {
            return userMapper.findByUsername(username);
        } catch (Exception e) {
            throw new ServiceException("Error finding user by username", e);
        }
    }
}

// Custom exception class
class ServiceException extends RuntimeException {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}