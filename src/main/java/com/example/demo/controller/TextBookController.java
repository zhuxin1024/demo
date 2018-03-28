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
import org.springframework.web.bind.annotation.RequestBody;
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
@Controller("textBookController")
@RequestMapping("/textBook")
public class TextBookController {
    @Autowired
    UserService userService;

    @Autowired
    TextBookService textBookService;

    @Autowired
    StockService stockService;

    private Logger logger = LoggerFactory.getLogger(TextBookController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request,@RequestParam(required = false) String title) {
        ModelAndView mv = new ModelAndView("textbookindex");
        DBQueryRequest dbQueryRequest = initTeamWorkQueryParam(request, mv, title);
        List<TextBook> textBooks = textBookService.listByTextBook(dbQueryRequest);
        List<Long> stocks = new ArrayList<>();
        for (TextBook textBook: textBooks) {
            stocks.add(stockService.selectByNumber(textBook.getNumber()));
        }
        mv.addObject("tblist", textBooks);
        mv.addObject("stocklist", stocks);
        mv.addObject("title", title);
        return mv;
    }

    @RequestMapping(value = "/info")
    public ModelAndView info(Long id) {
        ModelAndView mv = new ModelAndView("textbookinfo");
        TextBook textBook = textBookService.selectById(id);
        mv.addObject("info", textBook);
        return mv;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView("textbookedit");
        if (MyUtil.isNotEmpty(id)) {
            TextBook textBook = textBookService.selectById(Long.valueOf(id));
            Long stock = stockService.selectByNumber(textBook.getNumber());
            mv.addObject("info", textBook);
            mv.addObject("stock", stock);
        } else {
            logger.error("textBookId为空或不合法,id=" + id);
        }
        return mv;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView("textbookinsert");
        /*if (MyUtil.isNotEmpty(id)) {
            TextBook textBook = textBookService.selectById(Long.valueOf(id));
            mv.addObject("info", textBook);
            mv.addObject("isStock", true);
        } else {
            logger.error("textBookId为空或不合法,id=" + id);
        }*/
        return mv;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public ModelAndView save(TextBook tx,@RequestParam(required = false) String stock) {
        ResponseResult result = new ResponseResult();
        if (tx != null) {
            result = textBookService.save(tx);
        }
        if (stock != null) {
            stockService.save(tx.getNumber(),Long.valueOf(stock));
        }
        return new ModelAndView("redirect:http://127.0.0.1:8080/textBook/index");
    }

    @RequestMapping(value = "/textBooks")
    public ModelAndView getTextBook() {
        ModelAndView mav = new ModelAndView("home1");
        /*DBQueryRequest dbQueryRequest = initTeamWorkQueryParam(request, mav);
        List<TextBook> textBooks = textBookService.listByTextBook(dbQueryRequest);
        mav.addObject("tblist", textBooks);*/
        return mav;
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

    private DBQueryRequest initTeamWorkQueryParam(HttpServletRequest request, ModelAndView modelAndView, String title) {
        DBQueryRequest dbQueryRequest = new DBQueryRequest();

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        if (MyUtil.isBlank(currentPage))
            currentPage = Pagination.DEFAULT_PAGE_NO_STRING;
        if (MyUtil.isBlank(pageSize))
            pageSize = Pagination.DEFAULT_PAGE_SIZE_STRING;

        if (MyUtil.isNotEmpty(title)) {
            dbQueryRequest.put("title", title);
        }

        Pagination page = new Pagination(
                MyUtil.toInt(currentPage, MyUtil.toInt(Pagination.DEFAULT_PAGE_NO_STRING)),
                MyUtil.toInt(pageSize, MyUtil.toInt(Pagination.DEFAULT_PAGE_SIZE_STRING)));
        dbQueryRequest.setPage(page);
        modelAndView.addObject("page", page);
        return dbQueryRequest;
    }
}
