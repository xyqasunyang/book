package com.sun.www.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月30日
 */
public class ReptileUtil {


    public static Element getContent(String url, String selector) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String[] selectors = selector.split(">");
        Element element = doc.getElementsByTag("html").get(0);
        String[] strs;
        String sign = "";
        for (String str : selectors) {
            str = str.trim();
            if (str.split("\\.").length > 1) {
                //css选择器
                Elements elements = element.select(str);
                if (elements.isEmpty()) {
                    element = element.select(str.substring(0, str.lastIndexOf("."))).get(0);
                } else {
                    element = element.select(str).get(0);
                }
            } else if ((strs = str.split(":")).length > 1) {
                //tag选择器与同级比较
                int x = Integer.valueOf(strs[1].substring(strs[1].indexOf("(") + 1, strs[1].indexOf(")"))) - 2;
                Elements elements = element.getElementsByTag(strs[0]).get(1).siblingElements();
                if (x <= 0) {
                    element = element.getElementsByTag(strs[0]).get(x + 1);
                } else {
                    element = elements.get(x);
                }
            } else if ((strs = str.split("#")).length > 1) {
                //id选择器
                element = element.getElementById(strs[1]);
            } else {
                if (!sign.equals("") && (sign.indexOf(str) != -1 || str.indexOf(sign) != -1)) {
                    element = element.getElementsByTag(str).get(0).children().get(0);
                } else {
                    element = element.getElementsByTag(str).get(0);
                }
            }
            sign = str;
        }
        return element;
    }

    public static void main(String[] args) {
        getMovieList();
//        getDownLoadUrl();
    }


    public static String[] getList(Element element) {
        Elements elements = element.getElementsByTag("a");
        for (Element element1 : elements) {
            if (element1.hasClass("cur"))
                continue;
            System.out.println(element1.text());
            System.out.println(element1.absUrl("href"));
        }
        return new String[]{};
    }


    /**
     * 获取影视列表
     */
    public static void getMovieList() {
        try {
            String str = "body > div.warp > div.list3_cn_box.cn2_box_bg > div > div > div";
            Element element = getContent("http://www.meijutt.com/file/list1.html", str);
//            Elements moudelElements = element.select("page").get(0).getElementsByTag("a");
//            for(Element element1:moudelElements){
//                String url = element1.absUrl("href");
//                System.out.println(url);
//            }
            getMovieDetail(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getMovieDetail(Element element) {
        Elements elements = element.children();
        for (Element element1 : elements) {
            if (element1.hasClass("cn_box2")) {
                Element moduleElement = element1.getElementsByTag("a").get(0);
                String url = moduleElement.absUrl("href");
                String title = moduleElement.absUrl("title");
                title = title.substring(title.lastIndexOf("/")+1, title.length());
                System.out.println("url:" + url + ",title:" + title);
            }
        }
    }

    /**
     * 获取下载地址
     */
    public static void getDownLoadUrl() {
        try {
            String str = "body > div.warp > div.o_cn2 > div.o_list_cn_r > div > div > div.tabs-list.current-tab > div.down_list.max-height > ul ";
            Element element = getContent("http://www.meijutt.com/content/meiju23107.html", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
