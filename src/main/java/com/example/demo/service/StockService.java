package com.example.demo.service;

import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.utils.ResponseResult;

import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface StockService {
    Long selectByNumber(Long number);

    int insert(Long number, Long stock);

    int update(Long number, Long stock);

    int delete(Long id);

    ResponseResult save(Long number, Long stock);

}
