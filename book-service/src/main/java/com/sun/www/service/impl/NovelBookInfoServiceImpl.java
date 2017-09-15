package com.sun.www.service.impl;

import com.sun.www.bean.NovelBookInfoBean;
import com.sun.www.dao.NovelBookInfoDAO;
import com.sun.www.service.NovelBookInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by suny on 2017/7/25.
 */
@Service
public class NovelBookInfoServiceImpl implements NovelBookInfoService {

    Logger logger = Logger.getLogger(NovelBookInfoServiceImpl.class);

    @Autowired
    NovelBookInfoDAO novelBookInfoDAO;

    @Override
    public NovelBookInfoBean getNovelBookInfo(Integer novelBookInfoId) {
        return novelBookInfoDAO.getNovelBookInfo(novelBookInfoId);
    }

    @Override
    public int createNovelBookInfo(NovelBookInfoBean novelBookInfoBean) {
        return 0;
    }

}
