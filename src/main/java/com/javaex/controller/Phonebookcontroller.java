package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	public Phonebookcontroller() {	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//작동했는지 확인용
		System.out.println("PhoneBookController"); // 콘솔 출력되는 프린트

		
		//action 파라미터의 값이 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action);//업무구분
		
		if("list".equals(action)) { //리스트업무
			System.out.println("리스트");
			//리스트//////////////////////////////////////////////////////////////
			
			// db 데이터 가져온다 --> list
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			List<PersonVO> personList = phonebookDAO.personSelect();

			System.out.println(personList);
			
			//저밑에 있는 list.jsp에게 후반일을 시킨다
			// 1) request객체에 데이터를 넣어준다
			request.setAttribute("pList",personList);
			//                     별명  , 0x333  을 넣어준다
			
			
			
			// 2) list.jsp에 request 객체와 reponse 객체를 보낸다
			// ** forward 중요한 기술: 전달하는 기술 
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
			
			// ** forward 중요한 기술: 전달하는 기술 
			
			////////////////////////////////////////////////////////////////
			
			
		}else if("wform".equals(action)) { //등록폼업무 (등록업무랑 구별할 것)
			System.out.println("등록폼");
	
			//등록폼을 응답해야한다
			//1)DB관련 할일이 없다 - 안하면된다
			
			//2)jsp에게 화면을 그리게 한다(포워드)
			//writeForm.jsp 포워드한다
			RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
			rd.forward(request, response);
		
		}else if("write".equals(action)) { //등록업무        equals 중요!!!!
			System.out.println("등록");
			
			
			
			
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
