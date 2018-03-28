package com.example.demo.dao;

import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface StockMapper {
    @Select("select stocks from stock where number = #{number}")
    Long selectByNumber(@Param("number") Long number);

    @Insert("INSERT INTO stock(number, stocks) VALUES(#{number}, #{stocks})")
    int insert(@Param("number") Long number, @Param("stocks") Long stocks);

    @Update("update stock set stocks = #{stocks} where number = #{number}")
    int update(@Param("stocks") Long stock, @Param("number") Long number);

    @Delete("delete from stock where id = #{id}")
    int delete(Long id);
}
