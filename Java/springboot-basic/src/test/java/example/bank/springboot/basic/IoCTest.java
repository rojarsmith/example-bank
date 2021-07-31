package example.bank.springboot.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.bank.springboot.basic.config.AppConfig;
import example.bank.springboot.basic.pojo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rojar Smith
 *
 * @date 2021-07-30
 */
@SpringBootTest
@Slf4j
public class IoCTest {

	/*
	 * IoC container
	 */	
	@Test
	void basic() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = ctx.getBean(User.class);
		log.info(user.getId().toString());
		((ConfigurableApplicationContext) ctx).close();
	}

}
