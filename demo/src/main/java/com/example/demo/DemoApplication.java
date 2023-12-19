package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/*가급적이면 코딩 적게한다 -적게하지만 유지보수 좋음 -다형성활용
 * DemoApplication에서 main실행하는것으로 서버기동됨
 * Spring Boot -3.1.6버전 - Gradle{빌드도구-배포}
 * Tomcat 10.1.16 - Dynamic Web Application 6,0버전 -javax패키지는 활용불가 -jakarta패키지
 * 스프링부트 플젝에서 서블릿 실습을하려면 @ServletComponentScan 서블릿에대한객채주입을해줌
 * @WebServlet("*.gd")
 * 
 * 설정파일은
 * 1)application.properties - Properties클래스 동일함
 * application.yml - json형식 -반복코드 생략함
 * 
 * 
 */