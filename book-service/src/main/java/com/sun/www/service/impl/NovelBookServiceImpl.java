package com.sun.www.service.impl;

import com.sun.www.bean.NovelBookBean;
import com.sun.www.dao.NovelBookDAO;
import com.sun.www.service.NovelBookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * Created by suny on 2017/7/25.
 */
@Service
public class NovelBookServiceImpl implements NovelBookService {

    Logger logger = Logger.getLogger(NovelBookServiceImpl.class);

    @Autowired
    NovelBookDAO novelBookDAO;

    @Override
    public NovelBookBean getNovelBook(Integer novelBookId) {
        return novelBookDAO.getNovelBook(novelBookId);
    }

    @Override
    public int createNovelBook(NovelBookBean novelBookBean) {
        return novelBookDAO.createNovelBook(novelBookBean);
    }

    @Override
    public List<NovelBookBean> getNovelBookList(NovelBookBean novelBookBean) {
        return novelBookDAO.getNovelBookList(novelBookBean);
    }

    @Override
    public List<NovelBookBean> getBookDirectory(Integer bookInfoId) {
        return novelBookDAO.getBookDirectory(bookInfoId);
    }

    @Override
    public NovelBookBean getFront(NovelBookBean novelBookBean) {
        return novelBookDAO.getFront(novelBookBean);
    }

    @Override
    public NovelBookBean getBehind(NovelBookBean novelBookBean) {
        return novelBookDAO.getBehind(novelBookBean);
    }


}
