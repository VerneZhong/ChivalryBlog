package com.chivalry.java.basic.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Mr.Zxb
 * @description
 * @date 2023/11/16 19:40
 */
public class SimpleWebCrawler {
    public static void main(String[] args) {
        String url = "https://baijiahao.baidu.com/s?id=1782709145261077971&wfr=spider&for=pc"; // 更改为你想爬取的网址
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");

            for (Element link : links) {
                System.out.println("Link: " + link.attr("href"));
                System.out.println("Text: " + link.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
