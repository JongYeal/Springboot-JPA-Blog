package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일)  @Controller
// 사용자가 요청 -> 응답(Data)          @RestController
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1,"최종열","1234","email");
		System.out.println(TAG+" getter : " + m.getId());
		m.setId(5000);
		System.out.println(TAG+" getter : " + m.getId());
		
		System.out.println("Builder를 이용한 파라메트 설정");
		// builder()를 이용하면 생성자의 순서와 상관없이 입력가능, 파라메트 누락 가능
		Member m2 =  Member.builder().username("cjy").email("kcf279@daum.net").build();
		System.out.println(TAG+" getter : " + m2.getUsername());
		m2.setUsername("최종열");
		System.out.println(TAG+" getter : " + m.getUsername());
		System.out.println(TAG+" getter : " + m.getPassword());
		
		return "lombok test 완료";
		
	}
	
	//인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
	// http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) { // Get 전송 방식 : Params
		return "get 요청 : "+ m.getId() + ",  " + m.getUsername() + ",  " + m.getPassword() + ", " + m.getEmail(); 		
	}		
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//	return "get 요청 : ID ("+ id + "),  사용자명 (" + username + ")";		
//}	
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post") 
	//public String postTest(Member m) { // Post 전송 방식 : Body,  x-www-from-urlencoded
	//	return "post 요청 : "+ m.getId() + ",  " + m.getUsername() + ",  " + m.getPassword() + ", " + m.getEmail(); 				
	//}
	public String postTest(@RequestBody Member m) {//MessageConverter(그프링부트)  // Post 전송 방식 : Body,  raw/JSON
		//return "post 요청 : " + text; 		  //raw/text
    		return "post 요청 : "+ m.getId() + ",  " + m.getUsername() + ",  " + m.getPassword() + ", " + m.getEmail(); 	
	}	
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	//public String putTest() {
		//return  "put 요청 " ;
	public String putTest( Member m) {// Put 전송 방식 : Body,  x-www-from-urlencoded
		return  "put 요청: "+ m.getId() + ",  " + m.getUsername() + ",  " + m.getPassword() + ", " + m.getEmail(); 	  //raw/JSON
		
	}
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청"+ m.getId() + ",  " + m.getUsername() + ",  " + m.getPassword() + ", " + m.getEmail(); 	  //raw/JSON;
		
	}

}
