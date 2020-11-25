package com.example1.practice1.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentDTO {
	private int replyno;//일련번호
	private String replywriterid;//작성자아이디
	private int replycontentid;//댓글내용id
	private String replyip;//ip
	private Date replydate;//작성일시
	private String replytext;//내용
	

}
