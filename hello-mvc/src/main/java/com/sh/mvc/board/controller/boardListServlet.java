package com.sh.mvc.board.controller;

import com.sh.mvc.board.model.entity.Board;
import com.sh.mvc.board.model.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/boardList")
public class boardListServlet extends HttpServlet {

    BoardService boardService = new BoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자입력값 인코딩처리
        // 2. 사용자 입력값 가져오기



        // 3. 업무로직
        List<Board> boards = boardService.findAll();
        req.setAttribute("boards", boards);


        // 4. view단 처리
        req.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp").forward(req, resp);
    }
}