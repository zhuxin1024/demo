package com.example.demo.service.impl;

import com.example.demo.dao.ReserveMapper;
import com.example.demo.dao.StockMapper;
import com.example.demo.dao.TextBookMapper;
import com.example.demo.domain.Reserve;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.utils.ResponseResult;
import com.example.demo.service.ReserveService;
import com.example.demo.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
@Service("reserveService")
public class ReserveServiceImpl implements ReserveService{

    @Autowired
    ReserveMapper reserveMapperr;

    private Logger logger = LoggerFactory.getLogger(TextBookServiceImpl.class);

    @Override
    public List<Reserve> listReserve(DBQueryRequest dbQueryRequest) {
        List<Reserve> Reserve = null;
        try {
            Reserve = reserveMapperr.listReserve(dbQueryRequest);
            return Reserve;
        } catch (Exception e) {
            logger.error("获取订单list失败", e);
        }
        return Reserve;
    }

    @Override
    public ResponseResult save(Reserve textBook) {
        return null;
    }

 /*   @Override
    public ResponseResult save(TextBook textBook) {
        ResponseResult result = new ResponseResult(ResponseResult.success, "教材信息保存成功");
        Long id = textBook.getId();
        if (id == null) {
            reserveMapperr.insert(textBook);
        } else {
            reserveMapperr.update(textBook);
        }
        return result;
    }*/

    @Override
    public Reserve selectById(Long id) {
        return reserveMapperr.selectById(id);
    }

    @Override
    public int insert(Reserve reserve) {
        reserve.setCreated(new Date());
        reserve.setModified(new Date());
        return reserveMapperr.insert(reserve);
    }

    @Override
    public int update(Reserve reserve) {
        return reserveMapperr.update(reserve);
    }

    @Override
    public int delete(Long id) {
        return reserveMapperr.delete(id);
    }
}
