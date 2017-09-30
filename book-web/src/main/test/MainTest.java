import com.sun.www.bean.HtmlBean;
import com.sun.www.util.HttpClientUtil;
import com.sun.www.util.StringUtil;
import com.sun.www.util.VelocityUtil;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import sun.applet.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by suny on 2017/8/15.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        intervalDays("2012-09-25", "2017-08-15");
    }

    /**
     * 间隔天数
     *
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public static int intervalDays(String start, String end) throws Exception {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateStart = sdf.parse(start);
//        Date dateEnd = sdf.parse(end);
//        Long time = (dateEnd.getTime()-dateStart.getTime())/1000/60/60/24;
//        return time.intValue();
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push("a");
        stack.push(4);
        Queue queue = new LinkedBlockingQueue();
        Queue newQueue = new LinkedBlockingQueue();
        queue.add(1);
        queue.add(2);
        queue.add("a");
        queue.add(4);
        for (Object o : queue) {
            Object discard = queue.poll();
            if (!discard.toString().equals("2")) {
                newQueue.add(discard);
            }
        }
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        shuffle1(list);

//        Collections.shuffle(list);
        System.out.println(list);

        return 0;
    }

    public static <T> void shuffle1(List<T> list) {
        int size = list.size();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // 获取随机位置
            int randomPos = random.nextInt(size);

            // 当前元素与随机元素交换
            T temp = list.get(i);
            list.set(i, list.get(randomPos));
            list.set(randomPos, temp);
        }
    }


    @Test
    public void test() {
        String Xpath = "#blogBody > div > ul:nth-child(9) > li:nth-child(1) > p";
        String[] xpaths = Xpath.split(">");
        String html = HttpClientUtil.sendGet("https://my.oschina.net/u/2336761/blog/644330", null, null);
        Document doc = Jsoup.parse(html);
        Element element = doc;
        for (String path : xpaths) {
            if (path.equals(""))
                continue;
            element = getElement(path, element);
        }
        System.out.println(element);
    }

    public Element getElement(String path, Element element) {
        if (path.indexOf("#") != -1) {
            String id = path.split("#")[1];
            element = element.getElementById(id);
            return element;
        } else if (path.indexOf(".") != -1) {
            String[] tags = path.split("\\.");
            element = element.getElementsByAttributeValue("class", tags[1]).get(0);
            return element;
        } else if (path.indexOf(".") == -1 && path.indexOf(":") == -1) {
            element = element.getElementsByTag(path).get(0);
            return element;
        } else if (path.indexOf(":") != -1) {
//            String tag = path.split(":")[0].trim();
            String index = path.split("\\(")[1].split("\\)")[0];
            element = element.getElementsByIndexEquals(Integer.valueOf(index) - 1).get(0);
            return element;
        }
        return element;
    }


    @Test
    public void test2() {
        HtmlBean htmlBean = new HtmlBean().stringField("title").csspath("#blogBody > div > ul:nth-child(9) > li:nth-child(1) > p");
    }

    @Test
    public void test3() throws Exception {
        Properties p = new Properties();
        p.load(MainTest.class.getResourceAsStream("jdbc.properties"));
        Connection connection = DriverManager.getConnection(p.getProperty("jdbc_url"), p.getProperty("jdbc_username"), p.getProperty("jdbc_password"));
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\tinformation_schema. COLUMNS\n" +
                "WHERE\n" +
                "\ttable_schema = 'juhuatang'\n" +
                "AND table_name = 'dota_game';");
        List<String[]> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("COLUMN_NAME");
            String type = rs.getString("DATA_TYPE");
            String descrption = rs.getString("COLUMN_COMMENT");
            list.add(new String[]{type.equals("varchar") ? "String" : type, id, StringUtil.captureName(id)});
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("attrs", list);
        map.put("classNameLowCase", "teacher");
        map.put("classNameUpCase", "Teacher");
        VelocityUtil.template("ActionTemplate.vm", "D://test.java", map);
    }
}
