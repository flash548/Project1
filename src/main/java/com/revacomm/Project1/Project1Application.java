package com.revacomm.Project1;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://www.yawintutor.com/nosuchbeandefinitionexception-no-bean-named-available/#:~:text=NoSuchBeanDefinitionException:%20No%20bean%20named%20is,in%20the%20spring%20boot%20context.
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;


@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Bean
	public ApplicationRunner dbInit(PersonRepository personRepository) {
		return args -> {
			Person MattNath = new Person(1337, "Matt", "Nathanson", 49);
			personRepository.save(MattNath);

			Person America = new Person(1776, "John", "America", 245);
			personRepository.save(America);

			Person Sandler = new Person(2356, "Adam", "Sandler", 55);
			personRepository.save(Sandler);

			Person Bowie = new Person(4667, "David", "Bowie", 69);
			personRepository.save(Bowie);

			Person ChuckE = new Person(9898, "Chuck E.", "Cheese", 45);
			personRepository.save(ChuckE);

			Person Mozzarella = new Person(7366, "Mozzarella E.", "Cheese", 22);
			personRepository.save(Mozzarella);

			Person Appleseed = new Person(2039, "Johnny", "Appleseed", 17);
			personRepository.save(Appleseed);
		};
	}
}
