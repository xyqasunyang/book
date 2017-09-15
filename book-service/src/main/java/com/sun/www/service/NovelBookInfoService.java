package com.sun.www.service;


import com.sun.www.bean.NovelBookInfoBean;

/**
 * Created by suny on 2017/7/25.
 */
public interface NovelBookInfoService {
    NovelBookInfoBean getNovelBookInfo(Integer novelBookInfoId);

    int createNovelBookInfo(NovelBookInfoBean novelBookInfoBean);
}
