//package com.revacomm.Project1;
package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://www.yawintutor.com/nosuchbeandefinitionexception-no-bean-named-available/#:~:text=NoSuchBeanDefinitionException:%20No%20bean%20named%20is,in%20the%20spring%20boot%20context.
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Project1Application.class, args);
		// copy pasted // adapted, unsure what if anything this accomplishes
		//ctx.getBean("personService", PersonService.class);
	}
}
