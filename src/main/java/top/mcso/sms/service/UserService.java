package top.mcso.sms.service;

import top.mcso.sms.entity.User;

import java.util.List;

public interface UserService {

    boolean insertUser(User user);

    boolean deleteUserByUserNumber(String userNumber);

    boolean updateUser(User user);

    User findUserByUserNumber(String userNumber);

    List<User> findAllUsers();

}
