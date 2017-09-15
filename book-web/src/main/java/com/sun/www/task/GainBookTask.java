package com.sun.www.task;

import com.sun.www.bean.NovelBookBean;
import com.sun.www.service.NovelBookService;
import com.sun.www.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by suny on 2017/8/1.
 */
@Component
public class GainBookTask {

    private static String webUrl = "http://www.dingdiann.com/";
    private static String bookUrl = "http://www.dingdiann.com/ddk1597/";
    private static String  rex = "<a style=\"\" href=\"\\S+\">";
    private static String contentStartRex = "<div id=\"content\">";
    private static String contentEndRex = "<script>";
    private static String div = "</div>";
    private static String titleRex = "<div id=\"atitle\" class=\"atitle\">";

    @Autowired
    NovelBookService novelBookService;

    public void getBookTask(String bookName,String author) throws IOException{
        String str = HttpClientUtil.sendGet(bookUrl,null,null);
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String url = matcher.group().split("\"")[3];
            String section = webUrl+url;
            String mainBody = HttpClientUtil.sendGet(section,null,null);
            String content = mainBody.split(contentStartRex)[1].split(contentEndRex)[0];
            if(content==null||"".equals(content)){
                continue;
            }
            String title = mainBody.split("<h1>")[1].split("</h1>")[0];
            NovelBookBean novelBookBean = new NovelBookBean();
            novelBookBean.setAuthor(author);
            novelBookBean.setBookInfoId(1);
            novelBookBean.setContent(content);
            novelBookBean.setName(bookName);
            novelBookBean.setTitle(title);
            novelBookBean.setUrl(section);
            novelBookService.createNovelBook(novelBookBean);
        }
    }

    public static void main(String[] args) {
        try {
            new GainBookTask().getBookTask("","");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
