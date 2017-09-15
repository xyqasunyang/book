package com.sun.www.service;


import com.sun.www.bean.NovelBookBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by suny on 2017/7/25.
 */
public interface NovelBookService {
    NovelBookBean getNovelBook(Integer novelBookId);

    int createNovelBook(NovelBookBean novelBookBean);

    List<NovelBookBean> getNovelBookList(NovelBookBean novelBookBean);

    List<NovelBookBean> getBookDirectory(Integer bookInfoId);

    NovelBookBean getFront(NovelBookBean novelBookBean);

    NovelBookBean getBehind(NovelBookBean novelBookBean);

}
