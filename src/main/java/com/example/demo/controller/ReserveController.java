package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Reserve;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.User;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.page.Pagination;
import com.example.demo.domain.utils.MyUtil;
import com.example.demo.domain.utils.ResponseResult;
import com.example.demo.service.ReserveService;
import com.example.demo.service.StockService;
import com.example.demo.service.TextBookService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxin5 on 2018/2/26.
 * 教材controller
 */
@Controller("reserveController")
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    UserService userService;

    @Autowired
    ReserveService reserveService;

    @Autowired
    StockService stockService;

    @Autowired
    TextBookService textBookService;

    private Logger logger = LoggerFactory.getLogger(ReserveController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request,@RequestParam(defaultValue = "0") Long tid, @RequestParam(defaultValue = "-1") int status) {
        ModelAndView mv = new ModelAndView("reserveindex");
        long userId = (long)request.getSession().getAttribute("userId");
        String userType = (String)request.getSession().getAttribute("userType");
        if (userType.equals("2")) {
            //身份为老师
            tid = userId;
        }
        DBQueryRequest dbQueryRequest = initTeamWorkQueryParam(request, mv, tid, status);
        List<Reserve> reserves = reserveService.listReserve(dbQueryRequest);

        List<TextBook> textBooks = new ArrayList<>();
        for (Reserve reserve: reserves) {
            textBooks.add(textBookService.selectByNumber(reserve.getNumber()));
        }
        mv.addObject("tblist", textBooks);
        mv.addObject("rlist",  reserves);
        mv.addObject("status", status);
        return mv;
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public ResponseResult edit(String id, int status) {
        ResponseResult result = new ResponseResult();
        Reserve reserve = reserveService.selectById(Long.valueOf(id));
        Long stock = stockService.selectByNumber(reserve.getNumber());
        //发放订单
        if (status == 1) {
            if (stock >= reserve.getReserves()) {
                Long newStock = stock - reserve.getReserves();
                stockService.update(reserve.getNumber(), newStock);
                reserve.setStatus(1);
                int update = reserveService.update(reserve);
                result.setCode(ResponseResult.success);
                result.setDesc("发放成功！");
            } else {
                result.setCode(ResponseResult.failure);
                result.setDesc("库存不足，无法发放教材！");
            }
        } else if (status == 2){
            //驳回订单
            reserve.setStatus(2);
            int update = reserveService.update(reserve);
            result.setCode(ResponseResult.success);
            result.setDesc("驳回成功！");
        } else if (status == 3) {
            //删除订单
            reserve.setStatus(3);
            int update = reserveService.update(reserve);
            result.setCode(ResponseResult.success);
            result.setDesc("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView("reserveinsert");
        return mv;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public ModelAndView save(HttpServletRequest request, Reserve reserve, @RequestParam(required = false) String name) {
        if (reserve != null) {
            long userId = (long)request.getSession().getAttribute("userId");
            String userType = (String)request.getSession().getAttribute("userType");
            if (userType.equals("2")) {
                reserve.setTid(userId);
            }
            reserveService.insert(reserve);
        }
        return new ModelAndView("redirect:http://127.0.0.1:8080/reserve/index");
    }

    private DBQueryRequest initTeamWorkQueryParam(HttpServletRequest request, ModelAndView modelAndView, Long tid, int status) {
        DBQueryRequest dbQueryRequest = new DBQueryRequest();

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        if (MyUtil.isBlank(currentPage))
            currentPage = Pagination.DEFAULT_PAGE_NO_STRING;
        if (MyUtil.isBlank(pageSize))
            pageSize = Pagination.DEFAULT_PAGE_SIZE_STRING;

        dbQueryRequest.put("tid", tid);
        dbQueryRequest.put("status", status);

        Pagination page = new Pagination(
                MyUtil.toInt(currentPage, MyUtil.toInt(Pagination.DEFAULT_PAGE_NO_STRING)),
                MyUtil.toInt(pageSize, MyUtil.toInt(Pagination.DEFAULT_PAGE_SIZE_STRING)));
        dbQueryRequest.setPage(page);
        modelAndView.addObject("page", page);
        return dbQueryRequest;
    }
}
