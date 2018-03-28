package com.example.demo.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by zhuxin5 on 2018/3/17.
 */
public class TextBookSqlProvider {
    /**
     * 方式1：在工具类的方法里,可以自己手工编写SQL。
     */
    public String listById(@Param("id") String id) {
        return "select * from textbook where id =#{id}";
    }

    /**
     * 方式2：也可以根据官方提供的API来编写动态SQL。
     */
    public String getTextBook(@Param("id") String id) {
        return new SQL() {{
            SELECT("*");
            FROM("textbook");
            if (id != null) {
                WHERE("id = #{id}");
            }
        }}.toString();
    }
}
