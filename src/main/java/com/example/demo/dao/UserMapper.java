package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") Long id);

    @Select("select * from user where number = #{number} and password = #{password} and type = #{type}")
    User check(@Param("number") String number, @Param("password") String password, @Param("type") int type);

    @Insert("insert into user(name, number, pass, type) values(#{name}, #{number}, #{pass}, #{type})")
    int insert(User user);

    @Update("update user set name = #{name}, password = #{password} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Long id);
}
