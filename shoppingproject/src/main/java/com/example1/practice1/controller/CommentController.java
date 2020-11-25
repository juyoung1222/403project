package com.example1.practice1.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example1.practice1.domain.CommentDTO;
import com.example1.practice1.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource(name="com.example1.practice1.service.CommentService")
	CommentService mCommentService;
	
	// 로깅을 위한 변수
		private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	//댓글 등록
	@RequestMapping(value="/insert",method= {RequestMethod.POST, RequestMethod.GET } )
	@ResponseBody
	private int mCommentServiceInsert(@RequestParam String replywriterid,@RequestParam String replytext) throws Exception{
		
		logger.info("comment insert ....");
		System.out.println("mCommentServiceInsert...");
		//System.out.println("replyno[" + replyno + "]");
		
		System.out.println("replytext[" + replytext + "]");
		
		
		CommentDTO comment = new CommentDTO();
		//comment.setReplyno(replyno);
		comment.setReplywriterid(replywriterid);
		comment.setReplytext(replytext);
		//comment.setReplyip(replyip);
		
		logger.info("comment:"+comment);
		
		return mCommentService.commentInsertService(comment);
	}//end - private int mCommentServiceInsert(@RequestParam int replyno, @RequestParam String replytext) throws Exception{
	
	//댓글 리스트
    @RequestMapping(value="/list/{replyno}",method= {RequestMethod.POST, RequestMethod.GET } ) 
    @ResponseBody
    private List<CommentDTO> mCommentServiceList(@PathVariable int replyno,Model model) throws Exception{
		System.out.println("mCommentServiceList.....");
       
		logger.info("comment list{replyno}...." + replyno);
		return mCommentService.commentListService(replyno);
    }//end - private List<CommentVO> mCommentServiceList(@PathVariable int replyno,Model model) throws Exception{
    
    //댓글 수정
    @RequestMapping("/update")
    @ResponseBody
    private int mCommentServiceUpdate(@RequestParam int replyno, @RequestParam String replytext) throws Exception{
    	
    	logger.info("comment update...");
    	System.out.println("mCommentServiceUpdateProc...");
    	CommentDTO comment = new CommentDTO();
		comment.setReplyno(replyno);
		comment.setReplytext(replytext);
		
		return mCommentService.commentUpdateService(comment);
    }//end -  private int mCommentServiceUpdate(@RequestParam int replyno, @RequestParam String replytext) throws Exception{
    
    //댓글 삭제
    @RequestMapping("/delete/{replyno}")
    @ResponseBody
    private int mCommentServiceDelete(@PathVariable int replyno) throws Exception{
    	
    	logger.info("comment delete...");
    	System.out.println("mCommentServiceDelete");
    	
    	return mCommentService.commentDeleteService(replyno);
    }//end - private int mCommentServiceDelete(@PathVariable int replyno) throws Exception{
  
	

}
