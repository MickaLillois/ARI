package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public WebSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
		
				.authorizeRequests()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.antMatchers("/","/home","/menu_lecteur","/menu_auteur","/menu_livre")
					.permitAll()
					.anyRequest()
					.authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll()
				
				.and()
				.httpBasic();
	}


	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		
		UserDetails	nicoUser = User.builder()
				.username("nico")
				.password(passwordEncoder.encode("mdp"))
				.roles("USER") //ROLE_USER
				.build();
		
		UserDetails	mickaUser = User.builder()
				.username("micka")
				.password(passwordEncoder.encode("mdp"))
				.roles("ADMIN") 
				.build();
		
		return new InMemoryUserDetailsManager(
				nicoUser,
				mickaUser
		);
	}
}