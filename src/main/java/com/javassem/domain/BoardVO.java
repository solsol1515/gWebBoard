package com.javassem.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//VO(Value Object)
@Data // constructor, setter & getter 포함 
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class BoardVO {

	private int seq;				// 글 번호
	private String title;			// 제목
	private String writer;		// 작성자
	private String content;		// 글 내용
	private Date regDate;		// 작성일
	private int cnt;

	// private String searchCondition;
	// private Stirng searchKeyword;
}