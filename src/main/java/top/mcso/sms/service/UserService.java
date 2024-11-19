package top.mcso.sms.service;

import top.mcso.sms.entity.User;

import java.util.List;

public interface UserService {

    int insertUser(User user);

    int deleteUserByUserNumber(String userNumber);

    int updateUser(User user);

    User findUserByUserNumber(String userNumber);

    List<User> findAllUsers();

    User findUserByUsername(String username);
}
