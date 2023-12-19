package com.sh.mvc.board.controller;

import com.sh.mvc.board.model.entity.Board;
import com.sh.mvc.board.model.service.BoardService;
import com.sh.mvc.board.model.vo.BoardVo;
import com.sh.mvc.common.HelloMvcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/boardDetail")
public class BoardDetailServler extends HttpServlet {
    private BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);

        // 2. 업무로직
//        Board board = boardService.findById(id);
        BoardVo board = boardService.findById(id);
        System.out.println(board);

        // 개행문자(\n)을 <br>로 바꾸는법 (db바뀌는거아님, 뿌리기전에 바꾸는것)
        board.setContent(HelloMvcUtils.convertLineFeedToBr(board.getContent()));
        req.setAttribute("board", board);

        System.out.println(board);

        // 3. forward
        req.getRequestDispatcher("/WEB-INF/views/board/boardDetail.jsp").forward(req, resp);
    }
}