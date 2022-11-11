package memo.model;

import java.sql.Date;

//VO, DTO
//domain객체
//db table의 record ==> 클래스로 옮겨 구성

public class MemoVO {
	
	private int idx;
	private String name;
	private String msg;
	private java.sql.Date wdate;

	public MemoVO() {

	}
	
	public MemoVO(int idx, String name, String msg, Date wdate) {
		this.idx = idx;
		this.name = name;
		this.msg = msg;
		this.wdate = wdate;
	}
	
	//setter, getter
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public java.sql.Date getWdate() {
		return wdate;
	}

	public void setWdate(java.sql.Date wdate) {
		this.wdate = wdate;
	}
	
	
}
