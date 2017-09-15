package com.sun.www.contorller;

import com.sun.www.bean.NovelBookBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月15日
 */
@Controller
public class AnswerController {

    @RequestMapping(value = {"/index.html","/"}, method = RequestMethod.GET)
    public String book(ModelMap modelMap) {
        modelMap.addAttribute("title","小菊花 - 首页");
        return "index";
    }
}
