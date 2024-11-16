package top.mcso.sms.service;

import top.mcso.sms.entity.User;

import java.util.List;

public interface UserService {
    // 插入用户
    int insertUser(User user);

    // 删除用户
    int deleteUserByUserNumber(String userNumber);

    // 更新用户
    int updateUser(User user);

    // 根据用户编号查询用户
    User findUserByUserNumber(String userNumber);

    // 查询所有用户
    List<User> findAllUsers();

    // 根据用户名查询用户
    User findUserByUsername(String username);
}
