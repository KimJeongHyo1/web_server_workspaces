package com.sh.mvc.admin.contorller;

import com.sh.mvc.common.HelloMvcUtils;
import com.sh.mvc.member.model.entity.Gender;
import com.sh.mvc.member.model.entity.Member;
import com.sh.mvc.member.model.entity.Role;
import com.sh.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/admin/memberList")
public class AdminMemberListServlet extends HttpServlet {
    private MemberService memberService = new MemberService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 인코딩처리 이미 했어서 안해도됌
        // 1. 사용자 입력값 가져오기


        // 2. 업무로직
        List<Member> members = memberService.findAll(); // adminService만들어서 써도됌
        // 바로 전달되지않아서 req사용
        req.setAttribute("members", members);

        // 3. view단 처리
        req.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp").forward(req, resp);
    }
}