package com.example.demo.dao;

import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface TextBookMapper {
    @Select("select * from textbook where id = #{id}")
    TextBook selectById(@Param("id") Long id);

    @Select("select * from textbook where number = #{number}")
    TextBook selectByNumber(@Param("number") Long number);

    @Insert("insert into textBook(number, name, author, press ,price ,version) values(#{number}, #{name}, #{author}, #{press}, #{price}, #{version})")
    int insert(TextBook textBook);

    @Update("update textBook set number = #{number}, name = #{name}, author = #{author}, press = #{press}, price = #{price}, version = #{version} where id = #{id}")
    int update(TextBook textBook);

    @Delete("delete from textbook where id = #{id}")
    int delete(Long id);

    @Select({"<script>",
            "SELECT * FROM textbook",
            "WHERE 1=1",
            "<when test='title!=null'>",
            "AND name LIKE #{title}",
            "</when>",
            "</script>"})
    List<TextBook> listTextBook(DBQueryRequest dbQueryRequest);

    /*@Select("<script>"+
            "SELECT * FROM textbook"+
            "WHERE 1=1"+
            "<when test='title!=null'>"+
            "AND title = #{title}"+
            "</when>"+
            "</script>")*/
    /*@SelectProvider(type = TextBookSqlProvider.class, method = "getTextBook")
    List<TextBook> listByTextBook(@Param("id") Long id);*/
}
