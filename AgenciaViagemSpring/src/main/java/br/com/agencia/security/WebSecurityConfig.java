package br.com.agencia.security;




	
	
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.security.web.SecurityFilterChain;

	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public class WebSecurityConfig {

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	                .httpBasic()
	                .and()
	                .authorizeHttpRequests()
	                .antMatchers(HttpMethod.GET, "/cliente/**").permitAll()
                .antMatchers(HttpMethod.POST, "/cliente").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/cliente/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/login").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
			                NomePasswordAuthenticationFilter.class)
					
					.addFilterBefore(new JWTAuthenticationFilter(),
			                UsernamePasswordAuthenticationFilter.class);
	                .csrf().disable();
	        return http.build();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
				.withUser("USER")
				.password("password")
				.roles("ADMIN");
		}
	}

