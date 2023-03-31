package egovframework.yy.video.service;

import java.sql.Date;

public class ThumbVO {
	private int thumbNailId;
	private Date regDt;
	private Date updDt;
	private String delYn;
	private String orgNm;
	private String saveNm;
	private String savePath;
	private String fileType;
	private int boardId;
	
	
	public int getThumbNailId() {
		return thumbNailId;
	}
	public void setThumbNailId(int thumbNailId) {
		this.thumbNailId = thumbNailId;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public Date getUpdDt() {
		return updDt;
	}
	public void setUpdDt(Date updDt) {
		this.updDt = updDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public String getSaveNm() {
		return saveNm;
	}
	public void setSaveNm(String saveNm) {
		this.saveNm = saveNm;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	

	@Override
	public String toString() {
		return "ThumbVO [thumbNailId=" + thumbNailId + ", regDt=" + regDt + ", updDt=" + updDt + ", delYn=" + delYn
				+ ", orgNm=" + orgNm + ", saveNm=" + saveNm + ", savePath=" + savePath + ", fileType=" + fileType + "]";
	}
}
