package com.sun.www.contorller;

import com.sun.www.bean.NovelBookBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月15日
 */
@Controller
public class AnswerController {

    @RequestMapping(value = {"/index.html", "/"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request) {
        String sessionIp = request.getSession().getAttribute("ip") == null ? "" : request.getSession().getAttribute("ip").toString();
        String ip = request.getRemoteHost();
        if (ip.equals(sessionIp)) {
            return "second";
        }
        modelMap.addAttribute("title", "小菊花 - 首页");
        return "index";
    }

    @RequestMapping(value = "/second.html", method = RequestMethod.GET)
    public String second(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("title", "小菊花 - 测试");
        return "second";
    }

    @RequestMapping(value = "/identity.do", method = RequestMethod.POST)
    @ResponseBody
    public Object test(ModelMap modelMap, HttpServletRequest request, String name, String mobile) {
        String ip = request.getRemoteHost();
        request.getSession().setAttribute("ip", ip);
        return "second";
    }
}
