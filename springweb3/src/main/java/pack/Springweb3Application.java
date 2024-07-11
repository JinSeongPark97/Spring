package pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // 중요, 3개의 주요 어노테이션을 포함. 
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan : pack 패키지와 하위 패키지만 Scan 함

public class Springweb3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springweb3Application.class, args);
	}

}
