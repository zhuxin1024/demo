package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.TextBook;
import com.example.demo.domain.User;
import com.example.demo.domain.page.DBQueryRequest;
import com.example.demo.domain.page.Pagination;
import com.example.demo.domain.utils.MyUtil;
import com.example.demo.domain.utils.ResponseResult;
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
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TextBookService textBookService;

    @Autowired
    StockService stockService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("userInfo");
        long userId = (long)request.getSession().getAttribute("userId");
        User user = userService.selectById(userId);
        mv.addObject("info", user);
        mv.addObject("type", user.getType());
        return mv;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam Long userId) {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping(value = "/info")
    public ModelAndView info(Long id) {
        ModelAndView mv = new ModelAndView("textbookinfo");
        TextBook textBook = textBookService.selectById(id);
        mv.addObject("info", textBook);
        return mv;
    }

}
