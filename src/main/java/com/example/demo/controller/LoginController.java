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
import javax.servlet.http.HttpSession;

/**
 * Created by zhuxin5 on 2018/2/26.
 * 登录controller
 */
@Controller("loginController")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    TextBookService textBookService;

    @Autowired
    StockService stockService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    public static int TYPE = 0;

    @RequestMapping(value = "")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping(value = "/check")
    @ResponseBody
    public ResponseResult index(HttpServletRequest request, String number, String password, String userType) {
        ResponseResult result = new ResponseResult();
        User user = userService.check(number, password, Integer.parseInt(userType));
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userType",userType);
            session.setAttribute("userId",user.getId());
            session.setAttribute("userName",user.getName());
            session.setAttribute("isLogin","yes");
            result.setCode(ResponseResult.success);
            result.setDesc("登录成功！");
        } else {
            result.setCode(ResponseResult.failure);
            result.setDesc("登录失败，账号或密码错误！");
        }

        return result;
    }

    @RequestMapping(value = "/info")
    public ModelAndView info(Long id) {
        ModelAndView mv = new ModelAndView("textbookinfo");
        TextBook textBook = textBookService.selectById(id);
        mv.addObject("info", textBook);
        return mv;
    }

    @RequestMapping(value = "/out")
    public ModelAndView edit(HttpServletRequest request) {
        request.getSession().removeAttribute("userType");
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userName");
        request.getSession().removeAttribute("isLogin");
        return new ModelAndView("redirect:http://127.0.0.1:8080/login");
    }

}
