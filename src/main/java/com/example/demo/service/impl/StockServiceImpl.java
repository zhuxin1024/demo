package com.example.demo.service.impl;

import com.example.demo.dao.StockMapper;
import com.example.demo.dao.TextBookMapper;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.utils.ResponseResult;
import com.example.demo.service.StockService;
import com.example.demo.service.TextBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
@Service("stockService")
public class StockServiceImpl implements StockService{


    @Autowired
    StockMapper stockMapper;

    private Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Override
    public Long selectByNumber(Long number) {
        return stockMapper.selectByNumber(number);
    }

    @Override
    public int insert(Long number, Long stocks) {
        return stockMapper.insert(number, stocks);
    }

    @Override
    public int update(Long number, Long stock) {
        return stockMapper.update(stock, number);
    }

    @Override
    public int delete(Long id) {
        return stockMapper.delete(id);
    }

    @Override
    public ResponseResult save(Long number, Long stocks) {
        ResponseResult result = new ResponseResult(ResponseResult.success, "库存保存成功");
        Long isStock = stockMapper.selectByNumber(number);
        if (isStock != null) {
            stockMapper.update(stocks, number);
        } else {
            stockMapper.insert(number, stocks);
        }
        return result;
    }
}
