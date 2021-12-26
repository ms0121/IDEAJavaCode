package com.liu.utils;

import com.liu.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.ContentHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-31 - 15:45
 */
@Component
public class JsoupUtils {

    public static void main(String[] args) throws Exception {
//        getGoodsList("java");
    }

    public static List<Content> getGoodsList(String keyword) throws Exception {
        // 查询信息的地址，有了url，需要和服务器进行连接
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        // 使用jsoup进行解析网页得到Document对象
        Document document = Jsoup.parse(new URL(url), 30000);
        // 通过J_goodsList标签获取到网页中所有的商品信息
        Element element = document.getElementById("J_goodsList");
        // System.out.println(element.html());
        // 获取element中的所有li标签信息
        Elements elements = element.getElementsByTag("li");
        // 将获取到的数据全部封装在list中
        List<Content> contentList = new ArrayList<>();
        // 遍历elements（里面存放所有的粒标签信息），从而获取到每个商品的详细的信息
        for (Element li : elements) {
            String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();
            String name = li.getElementsByClass("p-name").eq(0).text();
            // 将查询得到的数据封装在list中
            // System.out.println(img);
            Content content = new Content(name, price, img);
            contentList.add(content);
        }
        return contentList;
    }

}
