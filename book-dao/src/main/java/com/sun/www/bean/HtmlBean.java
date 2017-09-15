package com.sun.www.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suny
 * @version 1.0
 * @date 2017年08月29日
 */
public class HtmlBean {
    private List list;
    private FieldBean fieldBean;

    public HtmlBean() {
        list = new ArrayList();
    }

    public HtmlBean stringField(String stringField) {
        fieldBean = new FieldBean();
        fieldBean.setName(stringField);
        return null;
    }

    public HtmlBean csspath(String csspath) {
        fieldBean.setCsspath(csspath);
        return null;
    }

    public HtmlBean build() {
        list.add(fieldBean);
        return null;
    }
}
