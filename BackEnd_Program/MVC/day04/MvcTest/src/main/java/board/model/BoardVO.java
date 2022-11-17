package board.model;

import java.sql.Timestamp;

public class BoardVO {
	
	private int num;
	private String userid;
	private String subject;
	private String content;
	private java.sql.Timestamp wdate;
	private String filename;
	private long filesize;
	
	public BoardVO() {
		
	}

	public BoardVO(int num, String userid, String subject, String content, Timestamp wdate, String filename,
			long filesize) {
		super();
		this.num = num;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.wdate = wdate;
		this.filename = filename;
		this.filesize = filesize;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(java.sql.Timestamp wdate) {
		this.wdate = wdate;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	
}///////////////////////////////////////
