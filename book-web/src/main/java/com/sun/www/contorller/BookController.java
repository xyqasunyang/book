package com.sun.www.contorller;

import com.sun.www.bean.NovelBookBean;
import com.sun.www.bean.ScheduleJobBean;
import com.sun.www.service.NovelBookService;
import com.sun.www.service.impl.JobTaskServiceImpl;
import com.sun.www.task.GainBookTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

/**
 * Created by suny on 2017/7/27.
 */
@Controller
public class BookController {

    @Autowired
    GainBookTask gainBookTask;
    @Autowired
    NovelBookService novelBookService;
    @Autowired
    JobTaskServiceImpl jobTaskService;

    @RequestMapping(value = "/{bookInfoId}/{bookId}.html", method = RequestMethod.GET)
    public String book(ModelMap modelMap, @PathVariable("bookId") Integer bookId, @PathVariable("bookInfoId") Integer bookInfoId) {
        NovelBookBean novelBookBean = new NovelBookBean();
        novelBookBean.setBookInfoId(bookInfoId);
        novelBookBean.setBookId(bookId);
        List<NovelBookBean> novelBookBeans = novelBookService.getNovelBookList(novelBookBean);
        NovelBookBean front = novelBookService.getFront(novelBookBean);
        NovelBookBean behind = novelBookService.getBehind(novelBookBean);
        if (novelBookBeans.isEmpty()) {
            return "404";
        }
        modelMap.addAttribute("books", novelBookBeans);
        modelMap.addAttribute("front", front == null ? null : front.getBookId());
        modelMap.addAttribute("behind", behind == null ? null : behind.getBookId());
        return "bookInfo";
    }

    @RequestMapping(value = "/{bookInfoId}.html", method = RequestMethod.GET)
    public String bookDirectory(ModelMap modelMap, @PathVariable("bookInfoId") Integer bookInfoId) {
        List<NovelBookBean> novelBookBeans = novelBookService.getBookDirectory(bookInfoId);
        if (novelBookBeans.isEmpty()) {
            return "404";
        }
        modelMap.addAttribute("books", novelBookBeans);
        return "bookDirectory";
    }

    @RequestMapping("/test.do")
    public void test() throws Exception {
        jobTaskService.addJob(new ScheduleJobBean());
    }
}
