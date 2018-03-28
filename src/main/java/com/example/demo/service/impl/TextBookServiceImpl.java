package com.example.demo.service.impl;

import com.example.demo.dao.TextBookMapper;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.utils.MyUtil;
import com.example.demo.domain.utils.ResponseResult;
import com.example.demo.service.TextBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
@Service("textBookService")
public class TextBookServiceImpl implements TextBookService{


    @Autowired
    TextBookMapper textBookMapper;

    private Logger logger = LoggerFactory.getLogger(TextBookServiceImpl.class);

    @Override
    public List<TextBook> listByTextBook(DBQueryRequest dbQueryRequest) {
        List<TextBook> textBooks = null;
        try {
            textBooks = textBookMapper.listTextBook(dbQueryRequest);
            return textBooks;
        } catch (Exception e) {
            logger.error("根据用户id：" + "获取用户失败", e);
        }
        return textBooks;
    }

    @Override
    public ResponseResult save(TextBook textBook) {
        ResponseResult result = new ResponseResult(ResponseResult.success, "教材信息保存成功");
        Long id = textBook.getId();
        if (id == null) {
            textBookMapper.insert(textBook);
        } else {
            textBookMapper.update(textBook);
        }
        return result;
    }

    @Override
    public TextBook selectById(Long id) {
        return textBookMapper.selectById(id);
    }

    @Override
    public TextBook selectByNumber(Long number) {
        return textBookMapper.selectByNumber(number);
    }

    @Override
    public int insert(TextBook textBook) {
        return textBookMapper.insert(textBook);
    }

    @Override
    public int update(TextBook textBook) {
        return textBookMapper.update(textBook);
    }

    @Override
    public int delete(Long id) {
        return textBookMapper.delete(id);
    }
}
