package com.my.movie.omProtal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.movie.omProtal.util.TypeConUtil;
import com.my.omCollect.util.JsoupUtil;
import com.my.omCollect.util.Player;
import com.my.omCollect.util.Video;

@Controller
public class VideoCollect {
	@RequestMapping(value = "index")
	public ModelAndView getIndex() {
		ModelAndView mod = new ModelAndView("index");
		List<Video> videos = JsoupUtil.processIndex("https://www.xvideos.com");
		String page_video = this.proVideos(videos);

		String pageList = JsoupUtil.ProcessPageList("https://www.xvideos.com");
		// System.out.println(page);
		mod.addObject("videos", page_video);
		mod.addObject("pageList", pageList);
		return mod;
	}

	@RequestMapping(value = "new")
	public ModelAndView getNewVideos(@RequestParam(value = "page") String page) {
		ModelAndView mod = new ModelAndView("new");
		List<Video> videos = JsoupUtil.processNew("https://www.xvideos.com/new/" + page);
		String page_video = this.proVideos(videos);

		String pageList = JsoupUtil.ProcessPageList("https://www.xvideos.com/new/" + page);
		// System.out.println(page);
		mod.addObject("videos", page_video);
		mod.addObject("pageList", pageList);
		return mod;
	}

	@RequestMapping(value = "search")
	public ModelAndView getSearchVideos(@RequestParam(value = "k") String search) {
		ModelAndView mod = new ModelAndView("search");
		List<Video> videos = JsoupUtil.processSearch("https://www.xvideos.com/?k=" + search);
		String page_video = this.proSearchVideos(videos);

		String pageList = JsoupUtil.ProcessPageList("https://www.xvideos.com/?k=" + search);
		// System.out.println(page);
		mod.addObject("videos", page_video);
		mod.addObject("pageList", pageList);
		return mod;
	}

	@RequestMapping(value = "searchList")
	public ModelAndView getSearchListVideos(@RequestParam(value = "k") String k, @RequestParam(value = "p") String p) {
		ModelAndView mod = new ModelAndView("search");
		List<Video> videos = JsoupUtil.processSearch("https://www.xvideos.com/?k=" + k + "&p=" + p);
		String page_video = this.proSearchVideos(videos);

		String pageList = JsoupUtil.ProcessPageList("https://www.xvideos.com/?k=" + k + "&p=" + p);
		// System.out.println(page);
		mod.addObject("videos", page_video);
		mod.addObject("pageList", pageList);
		return mod;
	}
	
	@RequestMapping(value = "player")
	public ModelAndView getSearchListVideos(@RequestParam(value = "pr") String pr) {
		ModelAndView mod = new ModelAndView("video");
		System.out.println("https://www.xvideos.com"+pr);
		Player player = JsoupUtil.processPlayer("https://www.xvideos.com"+pr);
		
		mod.addObject("video_player", player);
		return mod;
	}

	public String proVideos(List<Video> videos) {
		String page_video = "";
		for (Video video : videos) {
			String[] id = video.getVideo_id().split("_");
			page_video = page_video + "<div id=\"" + video.getVideo_id()
					+ "\" class=\"thumb-block \"><div class=\"thumb-inside\"><div class=\"microthumb\"><div class=\"microthumb-thumb\" style=\""
					+ video.getVideo_div_add()
					+ "\"></div><div class=\"microthumb-border\"></div></div><div class=\"thumb\"><a href=\"player?pr="
					+ video.getVideo_add() + "\">" + video.getVideo_img() + "</a></div></div><p><a href=\"player?pr="
					+ video.getVideo_add() + "\" title=\"" + video.getVideo_title() + "\">" + video.getVideo_title()
					+ "</a></p></div>" + "<script>xv.thumbs.prepareVideo(" + id[1] + ");</script>";
		}
		return page_video;
	}

	public String proSearchVideos(List<Video> videos) {
		String page_video = "";
		for (Video video : videos) {
			String[] id = video.getVideo_id().split("_");
			page_video = page_video + "<div id=\"" + video.getVideo_id()
					+ "\" class=\"thumb-block \"><div class=\"thumb-inside\"><div class=\"thumb\"><a href=\"player?pr="
					+ video.getVideo_add() + "\">" + video.getVideo_img() + "</a></div></div><p><a href=\"player?pr="
					+ video.getVideo_add() + "\" title=\"" + video.getVideo_title() + "\">" + video.getVideo_title()
					+ "</a></p></div>" + "<script>xv.thumbs.prepareVideo(" + id[1] + ");</script>";
		}
		return page_video;
	}

}
