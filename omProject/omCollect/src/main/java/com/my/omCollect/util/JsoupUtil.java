package com.my.omCollect.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	// 分析视频播放页面
	public static Player processPlayer(String url) {
		Document document = null;
		try {
			document = JsoupUtil.getDocument(url);
		} catch (IOException e) {
			System.out.println("同网站建立连接失败!!!");
		}
		
		//标题
		String title = document.getElementsByClass("page-title").first().toString();
		//播放器窗口
		String video_player = document.getElementById("video-player-bg").toString();
		
		Player player = new Player(title, video_player);
		return player;
	}

	// 分析网站首页
	public static List<Video> processIndex(String url) {
		Document document = null;
		try {
			document = JsoupUtil.getDocument(url);
		} catch (IOException e) {
			System.out.println("同网站建立连接失败!!!");
		}
		Elements items = document.getElementsByAttributeValue("class", "mozaique thumbs-4");
		Element item = items.first();
		Elements divs = item.getElementsByClass("thumb-block");
		List<Video> videos = new ArrayList<Video>();
		for (Element element : divs) {

			// System.out.println(element);
			// 获取视频id
			String video_id = element.attr("id");
			// 获取div位置
			String video_div_add = element.getElementsByClass("microthumb-thumb").first().attr("style");
			// 获取视频的相对位置
			String video_add = element.getElementsByClass("thumb").first().select("a").attr("href");
			// 获取div的图片信息
			String video_img = element.getElementsByClass("thumb").first().select("img").toString();
			// 获取视频的标题
			String video_title = element.select("p").first().select("a").text();
			Video video = new Video(video_id, video_div_add, video_add, video_img, video_title);
			// System.out.println();
			// System.out.println(video.toString());
			// System.out.println();
			videos.add(video);
		}

		return videos;
	}

	// 分析视频页面
	public static List<Video> processNew(String url) {
		Document document = null;
		try {
			document = JsoupUtil.getDocument(url);
		} catch (IOException e) {
			System.out.println("同网站建立连接失败!!!");
		}
		Elements items = document.getElementsByAttributeValue("class", "mozaique");
		Element item = items.first();
		Elements divs = item.getElementsByClass("thumb-block");
		List<Video> videos = new ArrayList<Video>();
		for (Element element : divs) {

			// System.out.println(element);
			// 获取视频id
			String video_id = element.attr("id");
			// 获取div位置
			String video_div_add = element.getElementsByClass("microthumb-thumb").first().attr("style");
			// 获取视频的相对位置
			String video_add = element.getElementsByClass("thumb").first().select("a").attr("href");
			// 获取div的图片信息
			String video_img = element.getElementsByClass("thumb").first().select("img").toString();
			// 获取视频的标题
			String video_title = element.select("p").first().select("a").text();
			Video video = new Video(video_id, video_div_add, video_add, video_img, video_title);
			// System.out.println();
			// System.out.println(video.toString());
			// System.out.println();
			videos.add(video);
		}

		return videos;
	}

	// 分析搜索视频页面
	public static List<Video> processSearch(String url) {
		Document document = null;
		try {
			document = JsoupUtil.getDocument(url);
		} catch (IOException e) {
			System.out.println("同网站建立连接失败!!!");
		}
		Elements items = document.getElementsByAttributeValue("class", "mozaique");
		Element item = items.first();
		Elements divs = item.getElementsByClass("thumb-block");
		List<Video> videos = new ArrayList<Video>();
		for (Element element : divs) {

			// System.out.println(element);
			// 获取视频id
			String video_id = element.attr("id");
			// 获取div位置，搜索页面没有相对位置
			// String video_div_add =
			// element.getElementsByClass("microthumb-thumb").first().attr("style");
			// 获取视频的相对位置
			String video_add = element.getElementsByClass("thumb").first().select("a").attr("href");
			// 获取div的图片信息
			String video_img = element.getElementsByClass("thumb").first().select("img").toString();
			// 获取视频的标题
			String video_title = element.select("p").first().select("a").text();
			Video video = new Video(video_id, video_add, video_img, video_title);
			// System.out.println();
			// System.out.println(video.toString());
			// System.out.println();
			videos.add(video);
		}

		return videos;
	}

	public static String ProcessPageList(String url) {
		String pages = "";
		Document document = null;
		try {
			document = JsoupUtil.getDocument(url);
		} catch (IOException e) {
			System.out.println("同网站建立连接失败!!!");
		}
		Elements elements = document.getElementsByClass("pagination").first().select("li");
		for (Element element : elements) {
			String page = "";
			String p = element.select("a").first().attr("href");
			// System.out.print(p + " ");
			String[] ps = p.split("/");
			// System.out.print(ps.length + " ");
			if (ps.length == 3) {
				page = element.select("a").first().attr("href", "/omProtal/new?page=" + ps[2]).toString();
			} else if (ps.length == 2) {
				String href = "/omProtal/searchList" + ps[1];
				page = element.select("a").first().attr("href", href).toString();
				// System.out.println(href);
			} else {
				page = element.select("a").first().attr("href", "#").toString();
			}

			pages = pages + "<li>" + page + "</li>";
		}
		return pages;
	}
}
