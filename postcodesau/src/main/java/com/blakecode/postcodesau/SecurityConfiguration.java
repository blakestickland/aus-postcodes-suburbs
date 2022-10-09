//package com.blakecode.postcodesau;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
////@EnableWebSecurity
////public class WebSecurityConfig {
////
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http
////			.authorizeHttpRequests((requests) -> requests
////				.antMatchers("/", "/aupostcodes/search").permitAll()
////				.anyRequest().authenticated()
////			)
////			.formLogin((form) -> form
////				.loginPage("/login")
////				.permitAll()
////			)
////			.logout((logout) -> logout.permitAll());
////
////		return http.build();
////	}
////
////	@Bean
////	public InMemoryUserDetailsManager userDetailsService() {
////		UserDetails user =
////			 User.withUsername("user")
////				 .password("password")
////				 .roles("USER")
////				 .build();
////				
////		return new InMemoryUserDetailsManager(user);
////	}
////}
//@Configuration
//public class SecurityConfiguration {
//	
////	@Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) 
////      throws Exception {
////        auth.inMemoryAuthentication()
////        	.withUser("user")
////        	.password(passwordEncoder()
////        	.encode("password"))
////        	.roles("USER");
////    }
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) 
//	  throws Exception {
//	    auth.inMemoryAuthentication()
//	      .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
//	      .and()
//	      .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
//	
//	
//	// secures all endpoints with HTTP Basic
////	@Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////            .authorizeHttpRequests((authz) -> authz
////                .anyRequest().authenticated()
////            )
////            .httpBasic(withDefaults());
////        return http.build();
////    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////    	http.cors().and().csrf().disable()
////        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
////        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        
////        http.authorizeRequests()
////	        .antMatchers("/", "/aupostcodes/search")
////	        .permitAll()
////	        .and()
////            .authorizeRequests()
////            .antMatchers("/aupostcodes/**")
////            .hasRole("ADMIN")
////            .anyRequest()
////            .authenticated()
////            .and().formLogin()
////            .loginPage("/login").permitAll()
////            .and()
////            .httpBasic();
////        
////        http.logout();
////        
////        return http.build();
////    }
//    
////	@Bean
////	public InMemoryUserDetailsManager userDetailsService() {
////		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////		UserDetails user =
////			 User.withUsername("admin")
////				 .password(encoder.encode("password"))
////				 .roles("ADMIN")
////				 .build();
////				
////		return new InMemoryUserDetailsManager(user);
////	}
//}
