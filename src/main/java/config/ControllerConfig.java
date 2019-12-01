package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import library.controller.UserController;
import library.model.User;


@Configuration
public class ControllerConfig {

	@Bean
	public UserController getUserController()
	{
		return new UserController();
	}
	
	@Bean
	public User getUser() 
	{
		return new User();
	}
}
