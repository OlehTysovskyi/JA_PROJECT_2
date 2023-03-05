package source.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("login").setViewName("login");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/entrants").setViewName("entrants");
		registry.addViewController("/entrant-registration").setViewName("entrant-registration");
		registry.addViewController("/entrant-enrolling").setViewName("entrant-enrolling");
		registry.addViewController("/received-entrants").setViewName("received-entrants");
		registry.addViewController("/403").setViewName("403");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
