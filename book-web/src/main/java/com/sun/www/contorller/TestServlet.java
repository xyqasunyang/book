package com.sun.www.contorller;

import com.sun.www.dao.NovelBookInfoDAO;
import com.sun.www.service.NovelBookService;
import com.sun.www.service.impl.NovelBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by suny on 2017/8/15.
 */
public class TestServlet extends HttpServlet {

    @Autowired
    NovelBookService novelBookService;

    @Override
    public void init() throws ServletException {
        super .init();

        ServletContext servletContext = this .getServletContext();

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        novelBookService = (NovelBookService)ctx.getBean("novelBookServiceImpl" );
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        novelBookService.getNovelBook(1);
    }
}
