package com.example1.practice1.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example1.practice1.controller.BoardController;
import com.example1.practice1.domain.BoardVO;
import com.example1.practice1.domain.Criteria;
import com.example1.practice1.domain.FileVO;
import com.example1.practice1.domain.SearchCriteria;
import com.example1.practice1.mapper.BoardMapper;

@Service("com.example1.practice1.service.BoardService")
public class BoardService {
	//로깅을 위한 변수
		private static final Logger logger 
			= LoggerFactory.getLogger(BoardService.class);
	
	@Resource(name="com.example1.practice1.mapper.BoardMapper")
	BoardMapper mapper;
	
	//게시글 등록
	public int insertBoard(BoardVO vo) throws Exception{
		logger.info("service insertBoard...." + vo);
		return mapper.insertBoard(vo);
	}
	//게시글 목록보기
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<BoardVO> boardList(SearchCriteria scri) throws Exception{
		logger.info("service :" + scri );
		List<BoardVO> list = mapper.boardList(scri);
			return mapper.boardList(scri);
	
		
	}
	//게시글 총 갯수
	public int listCount(SearchCriteria scri) throws Exception {
		logger.info("service listCount....." + scri);
		return mapper.listCount(scri);
	}
	
	//게시글 상세보기
	public BoardVO detail(int boardno) throws Exception{
		logger.info("service detail....." + boardno);
		return mapper.detail(boardno);
	}
	//게시글 수정
	public int update(BoardVO vo) throws Exception{
		logger.info("service update..... " + vo);
		System.out.println("BOARDNO : " + vo.getBoardno());
		System.out.println("SUBJECT : " + vo.getSubject());
		System.out.println("CONTENT : " + vo.getContent());
		return mapper.update(vo);
	}
	//게시글 삭제
	public int delete(int boardno) throws Exception{
		logger.info("service delete.... " + boardno);
		return mapper.delete(boardno);
	}
	
	//게시글 조회수
	public int boardHit(int boardno) throws Exception{
		logger.info("service hit ..." + boardno);
		return mapper.boardHit(boardno);
	
	}
	//파일 올리기
	public int fileInsert(FileVO file) throws Exception{
		logger.info("service fileInsert..... " + file);
		return mapper.fileInsert(file);
	}
	//파일 업로드 url보기
	public FileVO uploadFileList(int boardno) throws Exception{
		logger.info("service upload.... " + boardno);
		return mapper.uploadFileList(boardno);
	}
	//검색기능
	public List<BoardVO> searchList(SearchCriteria scri) throws Exception{
		logger.info("service search..." );
		return  mapper.searchList(scri);
		
	}

		
		
	
}
