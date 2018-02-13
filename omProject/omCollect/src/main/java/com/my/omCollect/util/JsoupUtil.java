package com.my.omCollect.util;

import java.io.IOException;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUtil {
	public static Document getDocument(String url) throws IOException {
		Document document = Jsoup.connect(url)
				.userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0").get();
		return document;
	}
	//分析网站首页
	public static void processIndex() {
		Document document = null;
		try {
			document = JsoupUtil.getDocument("http://www.xvideos.com");
		} catch (IOException e) {
			System.out.println("跟网站建立连接失败!!!");
		}
		//提取信息
		Elements elements = document.getElementsByAttributeValue("class", "mozaique thumbs-4");
		Element ele = elements.first();
		System.out.println(ele);
		
		
	}
	
}
