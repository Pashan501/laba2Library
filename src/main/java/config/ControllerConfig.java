package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import library.controller.UserController;


@Configuration
public class ControllerConfig {

	@Bean
	public UserController getUserController()
	{
		return new UserController();
	}
}
