package com.sun.www.bean;

import java.util.Date;

/**
 * Created by suny on 2017/7/25.
 */
public class BaseBean {

    private Integer isDelete;
    private Date createDate;
    private Date updateDate;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
