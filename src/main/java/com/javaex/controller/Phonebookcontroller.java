package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;

@WebServlet("/pbc")
public class Phonebookcontroller extends HttpServlet {

	// 필드
	private static final long serialVersionUID = 1L;

	// 생성자
	public Phonebookcontroller() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로직
		System.out.println("PhoneBookController"); // 콘솔 출력되는 프린트

		// db 데이터 가져온다 --> list
		PhonebookDAO phonebookDAO = new PhonebookDAO();
		List<PersonVO> personList = phonebookDAO.personSelect();

		System.out.println(personList);
		// html + list --> 두개를 섞어야 함
		
		
		// 응답문서 바디 추가한다

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
