package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	//접속위치 : http://localhost:8080/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("@Controlle에서 파일을 열때 시작 위치");
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명 : /피일명 (/home.html)
		return "/aaa.html"; // 풀경로 : src/main/resources/static/home.html		
	}
   @GetMapping("/temp/img")
	public String tempImage() {
		System.out.println("static에서 기존적으로 열 수 있는 이미지 파일 열기");
		return "/snowman.jpg"; 			
	}
   
//   @GetMapping("/temp/jsp")
//	public String tempJsp() {
//		System.out.println("test.jsp 파일 열기");
//		//return "/test.jsp"; //결로 찾지 못함
//		// application.yml파일의  spring: 에서 설정된 prefix, suffix 값에 의혀 결로가 결정됨
//        // prefix: /WEB-INF/views/
//		// suffix: .jsp 자동으로 생성됨
//		// return "/test.jsp" 풀네임 :  /WEB-INF/views//test.jsp.jsp
//		return "test"; 
//	}
   
}
