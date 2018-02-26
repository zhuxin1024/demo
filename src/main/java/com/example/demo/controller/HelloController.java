package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
@Controller("helloController")
@RequestMapping("/index")
public class HelloController {
    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    public ModelAndView home(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("index");
        User user = userService.selectById(id);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUser(@RequestParam Long id) {
        User user = userService.selectById(id);
        return JSONObject.toJSONString(user);
    }

    @RequestMapping(value = "/saveUser")
    @ResponseBody
    public String saveUser(@RequestParam String name, String pass) {
        User user = new User();
        user.setName(name);
        user.setPass(pass);
        int s = userService.insert(user);
        logger.info("保存结果：" + s);
        return JSONObject.toJSONString(s);
    }
}
