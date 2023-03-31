package egovframework.yy.video.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.yy.video.service.VideoService;

@Controller
public class VideoController {
	
	@Resource(name ="videoService")
	public VideoService vService;
	
	@RequestMapping("insVideoPage.do")
	public String insVideoPage() {
		return "movie/insVideoPage";
	}
	
	@RequestMapping("insVideo.do")
	@ResponseBody
	public String insVideo(@RequestParam Map<String, Object> commandMap, MultipartHttpServletRequest mutiparts) {
		
		String result = vService.videoIUD(commandMap, mutiparts);
		
		return result;
	}
	
	@RequestMapping("videoListPage.do")
	public String videoListPage() {
		return "movie/videoList";
	}
	
	
	@RequestMapping("videoList.do")
	@ResponseBody
	public Map<String, Object> videoList(@RequestParam Map<String, Object> commandMap) {
		
		Map<String, Object> resultMap = vService.getList(commandMap);
		
		return resultMap;
	}
	
	@RequestMapping("playVideo.do")
	@ResponseBody
	public Map<String, Object> playVideo(@RequestParam Map<String, Object> commandMap) {
		
		Map<String, Object> resultMap = vService.playVideo(commandMap);
		
		return resultMap;
	}
	
}
