package com.sh.ajax.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text")
public class TextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값
        String name = req.getParameter("name");
        int num = Integer.parseInt(req.getParameter("num"));
        System.out.println("name = " + name);
        System.out.println("num = " + num);

        // 2. 업무 로직
        if ((int) (Math.random() * 2) == 0)
            throw new RuntimeException("에러 발생💣");

        // 3. 응답 출력(메세지에 그냥 쓰겠다)
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("텍스트 보낼게");
        out.println("이름은 " + name + " 입니다.");
        out.println("숫자는 " + num + " 입니다.");
    }
}