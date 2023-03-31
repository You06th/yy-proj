package egovframework.yy.video.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface VideoService {
	
	public String videoIUD(Map<String, Object> commandMap, MultipartHttpServletRequest mutiparts);
	
	public Map<String, Object> playVideo(Map<String, Object> commandMap);
	
	public Map<String, Object> getList(Map<String, Object> commandMap);
}
