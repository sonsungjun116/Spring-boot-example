package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
		// HelloSpringApplication 클래스가 || 스프링부트는 톰캣이라는 웹서버를 내장하고 있고 실행과 동시에 같이 띄운다
		// 가끔 gradle을 통해서 run을 할때가 있는데 이경우 컴파일이 느림 해결방법 ->
		// preference -> gradle검색 -> Build and run using, Run tests using 둘다 intelli j로 설정
	}

}
