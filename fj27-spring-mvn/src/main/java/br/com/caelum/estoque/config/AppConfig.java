package br.com.caelum.estoque.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan(basePackages={"br.com.caelum.estoque"})
@EnableWebMvc
@ImportResource({"/WEB-INF/spring/spring-context.xml"})
public class AppConfig { 
	
}
