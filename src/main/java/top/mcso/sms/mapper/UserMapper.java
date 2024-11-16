package top.mcso.sms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.mcso.sms.entity.User;


@Mapper
public interface UserMapper {
    //添加新用户
    @Insert("insert into user(username, password, priority, user_number) values (#{username},#{password},#{priority},#{user_number})")
    User addUser(@Param("newUser") User newUser);

}


