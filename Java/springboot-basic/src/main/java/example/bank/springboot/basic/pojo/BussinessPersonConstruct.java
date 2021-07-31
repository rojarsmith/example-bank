package example.bank.springboot.basic.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import example.bank.springboot.basic.pojo.definition.Animal;
import example.bank.springboot.basic.pojo.definition.Person;

/**
 * @author Rojar Smith
 *
 * @date 2021-07-31
 */
public class BussinessPersonConstruct implements Person {

	private Animal animal;

	public BussinessPersonConstruct(@Autowired @Qualifier("cat") Animal animal) {
		this.animal = animal;
	}

	@Override
	public void service() {
		this.animal.use();
	}

	@Override
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
