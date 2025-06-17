<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List"    %>    
<%@ page import="com.javaex.vo.PersonVO"  %>

<% //자바문법
	List<PersonVO> personList = (List<PersonVO>)request.getAttribute("pList");
	//                          형변환 해줘야 함
	//parameter영역에 임의로 데이터를 추가하여 사용할 수 없다.(요청시 parameter값은 결정됨)
	//prrameter영역의 값과 attribute영역의 값을 구분하여 사용할 수 있어야 한다.
	
    System.out.println("여기는 jsp");
    System.out.println(personList);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>주소록</h1>
	
		<h2>전화번호 리스트</h2>
		<p>전화번호 리스트입니다.</p>
		
		<%
			for(int i=0; i<personList.size(); i++){
		%>	
				
			
		<table border ="1">
			<tbody>
				<tr>	
					<td>이름(name)</td>
					<td><%=personList.get(i).getName() %></td>
				</tr>
				<tr>
	            	<td>핸드폰(hp)</td>
	                <td><%=personList.get(i).getHp() %></td>
            	<tr>
            	<tr>
               		<td>회사(company)</td>
               		<td><%=personList.get(i).getCompany() %></td>
            	<tr>      
            	<tr>
               		<td>[수정폼으로 이동]</td>
        			<td><a href="http://localhost:8080/phonebook2/pbc?action=delete&no=3">[삭제]</a></td>   <!-- 원래 버튼으로 해야된다 js필요 안배워서 a태그로 구현 -->
            	<tr>    

			</tbody>
		</table>
		
		<br>
		<%	
		}	
		%>
		
		[주소록 작성폼 이동] : 주소창에 <br>Add commentMore actions
		http://localhost:8080/phonebook2/pbc?action=wformAdd commentMore actions
		
		<br>입력하시고 엔터입력
		
		<a href="http://localhost:8080/phonebook2/pbc?action=wform">주소록 작성폼 이동</a>
	
	</body>
</html>