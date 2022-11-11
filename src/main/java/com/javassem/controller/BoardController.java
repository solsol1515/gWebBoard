package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
   
   @Autowired
   private BoardService boardService;
   
   
   @RequestMapping("getBoardList.do") // 목록보기
   public void getBoardList(Model m) {
      List<BoardVO> list=boardService.getBoardList();
      m.addAttribute("boardList", list);
   } // end of getBoardList
   
   
   @RequestMapping("insertBoard.do") // 새글쓰기
   public void insertBoard() {
   } // end of insertBoard
   
   @RequestMapping("saveBoard.do") // 저장하기
   public String saveBoard(BoardVO boardVO){
	 //  System.out.println(boardVO.getContent());
	boardService.insertBoard(boardVO);
	return "redirect:getBoardList.do";
   } // end of saveBoard
   
   @RequestMapping("getBoard.do") // 작성한 글 보기
   public void getBoard(BoardVO boardVO, Model m) { // 데이터 넘겨주기 위해서 Model m 사용
	   m.addAttribute("board", boardService.getBoard(boardVO));
		/*
		 * BoardVO resultVO = boardService.getBoard(boardVO); m.addAttribute("board",
		 * resultVO);
		 */
   } // end of getBoard 
   
   // 수정하기
   @RequestMapping("updateBoard.do")
   public String updateBoard(BoardVO vo) {
	   boardService.updateBoard(vo);
	   return "redirect:getBoardList.do";
   }
   

   // 삭제하기
   @RequestMapping("deleteBoard.do")
   public String deleteBoard(BoardVO vo) {
      boardService.deleteBoard(vo);
      return "redirect:getBoardList.do";
   }
   
   
}