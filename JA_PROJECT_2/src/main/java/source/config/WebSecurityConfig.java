package source.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import source.security.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	public void configAuthentification(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/home").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMINISTRATOR')")
				.antMatchers("/entrants").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMINISTRATOR')")
				.antMatchers("/entrant-registration").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMINISTRATOR')")
				.antMatchers("/entrant-enrolling").access("hasRole('ROLE_ADMINISTRATOR')")
				.antMatchers("/received-entrants").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMINISTRATOR')")
				.anyRequest().permitAll().and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/home").usernameParameter("email")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout").and()
				.exceptionHandling().accessDeniedPage("/403").and().csrf();
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
