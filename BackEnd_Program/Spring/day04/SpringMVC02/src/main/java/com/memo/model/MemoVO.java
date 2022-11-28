package com.memo.model;
import java.util.Date;
import lombok.*;

@Setter
@Getter
@ToString(includeFieldNames = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemoVO { 
	
	private int idx;
	private String name;
	private String msg;
	private Date wdate;

}
