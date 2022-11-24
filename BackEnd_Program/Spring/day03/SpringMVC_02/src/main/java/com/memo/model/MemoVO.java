package com.memo.model;

import java.util.Date;

import lombok.Data;

@Data
//@Setter >> Setter만 생성
//@Getter
//@ToString(includeFieldNames)
public class MemoVO {
	
	private int idx;
	private String name;
	private String msg;
	private Date wdate;
	
}
