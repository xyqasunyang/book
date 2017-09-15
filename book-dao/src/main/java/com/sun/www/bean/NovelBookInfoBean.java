package com.sun.www.bean;

/**
 * Created by suny on 2017/8/1.
 */
public class NovelBookInfoBean extends BaseBean {
    private Integer bookInfoId;
    private String name;
    private String author;
    private Integer type;
    private Integer serialize;
    private String url;

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSerialize() {
        return serialize;
    }

    public void setSerialize(Integer serialize) {
        this.serialize = serialize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NovelBookInfoBean{" +
                "bookInfoId=" + bookInfoId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", serialize=" + serialize +
                ", url='" + url + '\'' +
                '}';
    }
}
