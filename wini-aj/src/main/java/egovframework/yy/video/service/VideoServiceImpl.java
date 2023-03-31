package egovframework.yy.video.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.yy.video.dao.VideoDAO;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

	@Resource(name = "VideoDAO")
	private VideoDAO vDao;

	@Override
	public String videoIUD(Map<String, Object> commandMap, MultipartHttpServletRequest mutiparts) {
		// 게시글 내용 저장
		int boardId = (int) vDao.insert("video.insBoard", commandMap);
		
		// 결과를 알려줄 메시지 변수
		String msg = "";

		// 저장경로 (서버에 저장 .meta안에)
		String rootPath = mutiparts.getSession().getServletContext().getRealPath("").replaceAll("\\\\","/"); // root폴더 (로컬저장 경로)
		String rootFolder = "upload";
		
		String saveRootPath =  rootPath + rootFolder;
		//saveRootPath = uploadFolder
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String toDay = sdf.format(date);

		String directoryPath = toDay.replace("-", "/"); // 날짜 구분자 형식을 경로구분자로 변경 -> 날짜별로 폴더가 생기게

		// 폴더생성(날짜별로 파일을 저장할 폴더를 생성)
		File uploadFolder = new File(saveRootPath, directoryPath);
		//uploadFolder = uploadPath
		
		// 실제로 파일이 올라갈 폴더의 경로
		//String uploadPath = saveRootPath + "/" + directoryPath;

		// 만약 폴더가 존재하지 않는다면 폴더를 생성하도록
		if (uploadFolder.exists() == false) {
			uploadFolder.mkdirs();
		}

		// videofile
		List<MultipartFile> files = mutiparts.getFiles("video");
		FileVO fileVo = new FileVO();

		// thumbNail을 등록할때 video 아이디가 필요하므로
		int videoId = 0;

		if (!files.isEmpty()) {

			for (MultipartFile file : files) {

				String orgNm = file.getOriginalFilename();

				// 확장자 가져오기
				int startIndex = file.getOriginalFilename().indexOf('.') + 1;
				String fileType = file.getOriginalFilename().substring(startIndex);
				// 원본파일 이름이 같을 수도 있기 때문에
				String uuid = UUID.randomUUID().toString();

				String saveNm = uuid;
				
				/* 파일 위치, 파일 이름을 합친 File 객체 */
				File saveFile = new File(uploadFolder, orgNm);
			
				String saveFolder = saveRootPath.replaceAll(rootPath, "");
				// VO에 저장

				fileVo.setOrgNm(orgNm); 
				fileVo.setSaveNm(saveNm);
				fileVo.setFileType(fileType); 
				fileVo.setSavePath(saveFolder + "/" + directoryPath);
				fileVo.setBoardId(boardId); 
				

				try {
					file.transferTo(saveFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			vDao.insert("video.insertFileInfo", fileVo);
		}

		// ThumbNail
		List<MultipartFile> thumbs = mutiparts.getFiles("thumbNail");

		ThumbVO thumbVo = new ThumbVO();

		if (!thumbs.isEmpty()) {

			for (MultipartFile thumb : thumbs) {

				String orgNm = thumb.getOriginalFilename();

				// 확장자 가져오기
				int startIndex = thumb.getOriginalFilename().indexOf('.') + 1;
				String fileType = thumb.getOriginalFilename().substring(startIndex);
				// 원본파일 이름이 같을 수도 있기 때문에
				String uuid = UUID.randomUUID().toString();

				String saveNm = uuid;
				
				/* 파일 위치, 파일 이름을 합친 File 객체 */
				File saveFile = new File(uploadFolder, orgNm);
			
				String saveFolder = saveRootPath.replaceAll(rootPath, "");
				// VO에 저장

				thumbVo.setOrgNm(orgNm); 
				thumbVo.setSaveNm(saveNm);
				thumbVo.setFileType(fileType); 
				thumbVo.setSavePath(saveFolder + "/" + directoryPath);
				thumbVo.setBoardId(boardId); 
			

				try {
					thumb.transferTo(saveFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			vDao.insert("video.insertThumb", thumbVo);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> playVideo(Map<String, Object> commandMap) {

		Map<String, Object> resultMap = new HashMap<>();

		resultMap = (Map<String, Object>) vDao.select("video.getVideoInfo", commandMap);

		return resultMap;
	}

	@Override
	public Map<String, Object> getList(Map<String, Object> commandMap) {
		Map<String, Object> resultMap = new HashMap<>();

		List videoList = vDao.list("video.getList");

		resultMap.put("videoList", videoList);
		System.out.println(videoList);
		return resultMap;
	}

}
