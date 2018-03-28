package com.example.demo.service;

import com.example.demo.domain.Reserve;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.utils.ResponseResult;

import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface ReserveService {
    Reserve selectById(Long id);

    int insert(Reserve reserve);

    int update(Reserve reserve);

    int delete(Long id);

    List<Reserve> listReserve(DBQueryRequest dbQueryRequest);

    ResponseResult save(Reserve textBook);
}
