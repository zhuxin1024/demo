package com.example.demo.service;

import com.example.demo.domain.TextBook;
import com.example.demo.domain.User;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.utils.ResponseResult;

import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface TextBookService {
    TextBook selectById(Long id);

    TextBook selectByNumber(Long number);

    int insert(TextBook textBook);

    int update(TextBook textBook);

    int delete(Long id);

    List<TextBook> listByTextBook(DBQueryRequest dbQueryRequest);

    ResponseResult save(TextBook textBook);
}
