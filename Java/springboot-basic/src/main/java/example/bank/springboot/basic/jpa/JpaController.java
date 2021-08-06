package example.bank.springboot.basic.jpa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rojar Smith
 *
 * @date 2021-08-06
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {

	@Autowired
	JpaUserRepository jpaUserRepository;

	@PostConstruct
	void init() {
		User user = new User();
		user.setUserName("name_1");
		user.setNote("note_1");
		user.setSex(SexEnum.MALE);
		jpaUserRepository.save(user);
	}

	@RequestMapping("/user")
	@ResponseBody
	public User getUser(Long id) {
		User user = jpaUserRepository.findById(id).get();
		return user;
	}
}
