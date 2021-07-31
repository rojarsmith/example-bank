package example.bank.springboot.basic;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.bank.springboot.basic.config.AppConfig;
import example.bank.springboot.basic.config.AppConfig3Party;
import example.bank.springboot.basic.config.AppConfigComponent;
import example.bank.springboot.basic.config.AppConfigExclude;
import example.bank.springboot.basic.pojo.User;
import example.bank.springboot.basic.pojo.UserComponent;
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
		assertTrue(user.getId().toString().equals("1"));
		((ConfigurableApplicationContext) ctx).close();
	}

	@Test
	void basicComponentScan() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigComponent.class);
		UserComponent user = ctx.getBean(UserComponent.class);
		log.info(user.getId().toString());
		assertTrue(user.getId().toString().equals("2"));
		((ConfigurableApplicationContext) ctx).close();
	}

	@Test
	void basicComponentScanExclude() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigExclude.class);
		Exception exception = assertThrows(NoSuchBeanDefinitionException.class, () -> {
			@SuppressWarnings("unused")
			UserComponent user = ctx.getBean(UserComponent.class);
		});
		assertTrue(exception.getMessage().contains("No"));
		((ConfigurableApplicationContext) ctx).close();
	}

	@Test
	void basicComponent3Party() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3Party.class);
		DataSource dataSource = ctx.getBean(DataSource.class);
		assertTrue(dataSource.toString().contains("Source"));
		((ConfigurableApplicationContext) ctx).close();
	}

}
