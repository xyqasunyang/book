package com.sun.www.contorller;

import com.sun.www.bean.BaseBean;
import com.sun.www.result.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月25日
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(BaseBean baseBean) {
        ResultEntity resultEntity = new ResultEntity();
        return resultEntity;
    }

}
