package example.bank.springboot.basic.aop.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "example.bank.springboot.basic.aop.example" })
@SpringBootApplication
public class ApplicationAopExapmle {

	// The example work after removing this function.
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationAopExapmle.class, args);
	}

}
