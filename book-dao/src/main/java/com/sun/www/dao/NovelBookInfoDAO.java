package com.sun.www.dao;


import com.sun.www.bean.NovelBookInfoBean;

/**
 * Created by suny on 2017/7/25.
 */
public interface NovelBookInfoDAO {

    NovelBookInfoBean getNovelBookInfo(Integer novelBookInfoId);

    int createNovelBookInfo(NovelBookInfoBean novelBookInfoBean);

}
