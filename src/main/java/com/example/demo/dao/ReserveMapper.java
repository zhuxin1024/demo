package com.example.demo.dao;

import com.example.demo.domain.Reserve;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface ReserveMapper {
    @Select("select * from reserve where id = #{id}")
    Reserve selectById(@Param("id") Long id);

    @Insert("insert into reserve(number, reserves, created, modified ,status, tid, tname, classinfo) values(#{number}, #{reserves}, #{created}, #{modified}, #{status}, #{tid}, #{tname}, #{classinfo})")
    int insert(Reserve reserve);

    @Update("update reserve set number = #{number}, reserves = #{reserves}, modified = #{modified}, status = #{status}, tid = #{tid}, classinfo = #{classinfo} where id = #{id}")
    int update(Reserve reserve);

    @Delete("delete from reserve where id = #{id}")
    int delete(Long id);

    /*@Select("select * from reserve")*/

    @Select({"<script>",
            "SELECT * FROM reserve",
            "WHERE 1=1",
            "<when test='tid!=0'>",
            "AND tid = #{tid}",
            "</when>",
            "<when test='status==0'>",
            "AND status = #{status}",
            "</when>",
            "</script>"})
    List<Reserve> listReserve(DBQueryRequest dbQueryRequest);

    /*"<when test='status!=0'>",
            "AND status != 0",
            "</when>",
*/
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
