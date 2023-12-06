package com.sh.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Servlet - 업무로직 처리. jsp로 forwarding.
 * JSP - html 작성
 *
 */
@WebServlet("/testPerson3.do") // url같은거 있으면 안켜짐(tomcat이 받아서 그걸 뿌려줌)
public class TestPersonServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청메세지에 대한 인코딩 처리
		req.setCharacterEncoding("utf-8"); // 대소문자 구별 안함
		
		// 사용자 입력값 처리
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String animal = req.getParameter("animal");
		String[] foods = req.getParameterValues("food");
		System.out.println(name);
		System.out.println(color);
		System.out.println(animal);
		System.out.println(Arrays.toString(foods));
		
		// 업무로직. . .(추천음식같은) : 사용자의 취향을 고려해 추천키워드를 제공한다
		// switch statement : JDK 17 이상
		String recommendation = switch(color) {
		case "빨강" -> "매운 떡볶이";
		case "노랑" -> "노랑 동화책";
		case "초록" -> "초록색 상추쌈";
		case "파랑" -> "시원한 사이다";
		default -> "나도 몰라";
		}; // 서버에서 생성한 data
		System.out.println(recommendation);
		// jsp에 전달하기 - request객체에 속성으로 저장
		req.setAttribute("recommendation", recommendation);
		
		// jsp 포워딩 (RequestDispatcher = 요청을 보낸다라고 생각하면됨)
		// 파일 경로(절대경로) src/main/webapp(웹루트) 이하부터 작성
		RequestDispatcher reqDispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/testPersonResult.jsp");
		reqDispatcher.forward(req, resp);
		
		
	
	}
}
