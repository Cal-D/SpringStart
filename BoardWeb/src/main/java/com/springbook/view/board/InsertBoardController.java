package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class InsertBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");
		
		//request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setWriter(writer);
		boardVO.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(boardVO);
		
		//jsp 로 할경우 세션에 저장된 글 목록을 갱신이 안되겠지? .do 로 해야 dispatcherServlet을 통해 session 에 매핑이 될거니까
		return "getBoardList.do";
	}
}
