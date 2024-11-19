package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.User;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 插入用户
    @Insert("insert into user (user_number, password, priority ) values ( #{userNumber}, #{password}, #{priority})")
    @Options(useGeneratedKeys = true, keyProperty = "userNumber")
    boolean insertUser(User user);

    // 删除用户
    @Delete("delete from user where user_number = #{userNumber}")
    boolean deleteByUserNumber(@Param("userNumber") String userNumber);

    // 更新用户
    @Update("update user set password = #{password}, priority = #{priority} where user_number = #{userNumber}")
    boolean updateUser(User user);

    // 根据用户编号查询用户
    @Select("select * from user where user_number = #{userNumber}")
    User findByUserNumber(@Param("userNumber") String userNumber);

    // 查询所有用户
    @Select("select * from user")
    List<User> findAll();


}


