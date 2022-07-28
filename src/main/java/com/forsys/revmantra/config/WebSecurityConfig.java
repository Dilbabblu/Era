package com.forsys.revmantra.config;

import java.net.URI;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.forsys.revmantra.filter.CsrfGrantingFilter;
import com.forsys.revmantra.filter.NoAntPathRequestMatcher;
import com.forsys.revmantra.services.RmanUserDetailsService;

@EnableWebSecurity(debug = false)
@ComponentScan("com.forsys.revmantra.services")
public class WebSecurityConfig {
	
	private static final String LOGIN_URL = "/auth/login.html";

	@Autowired
	private RmanUserDetailsService userDetailsService;
	
	@Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
	
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws AuthenticationException {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());

		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Configuration
	@Order(1)
	public class JwtsecurityConfig extends WebSecurityConfigurerAdapter{
		

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			String[] patterns = new String[] {
			        "/api/sfqi/**"
			    };
			http
			.csrf().disable()
			.requestMatchers(reqMatch->reqMatch.antMatchers(patterns))
			.authorizeRequests().antMatchers("/api/sfqi/authenticate").permitAll()
			.anyRequest().authenticated()
//			.and()
//			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.httpBasic()
//			.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
			;
		}

	}
	
	@Configuration
	public class FormsecurityConfig extends WebSecurityConfigurerAdapter{
	
			@Override
			protected void configure(HttpSecurity http) throws Exception {
				String[] patterns = new String[] {
				        "/",
				        "/login",
				        "/auth/**/*",
				        "/index.html",
				        "/js/**",
				        "/css/**",
				        "/images/**",
				        "/app/resources/**",
				        "/app/**",
				        "/api/**",
				        "/upload/**",
				        "/favicon.ico",
				        "/forgotPassword/**",
				        "/resetPassword/**",
				        "/saveResetPassword/**",
				        LOGIN_URL,
				        "/assets/**",
				        "/basic/loginsuccess",
				        "/logout",
				        "/oauth2/loginsuccess",
				        "/*.css","/*.js","/*.woff*","/*.ttf*","/*.png"
				    };
				
				http.authorizeRequests().antMatchers("/auth/**").permitAll()
				        .antMatchers("/js/**").permitAll()
						.antMatchers("/css/**").permitAll()
						.antMatchers("/images/**").permitAll()
						.antMatchers("/app/resources/**").permitAll()
						.antMatchers("/app**").authenticated()
						.antMatchers("/index.html").authenticated()
						.antMatchers("/api/sfqi/**").denyAll()
						.antMatchers("/api/**").authenticated()
						.antMatchers("/upload/**").authenticated()
						.antMatchers("/forgotPassword/**").permitAll()
						.antMatchers("/resetPassword/**").permitAll()
						.antMatchers("/saveResetPassword/**").permitAll()
						.antMatchers(HttpMethod.OPTIONS, "**").denyAll()
						.antMatchers(HttpMethod.PATCH, "**").denyAll()
						.antMatchers(HttpMethod.TRACE, "**").denyAll()
						.and().httpBasic().and().formLogin()
						.loginPage(LOGIN_URL)
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/basic/loginsuccess", true)
		//				.defaultSuccessUrl("/index.html", true)
						.and()
						.logout().logoutUrl("/logout").deleteCookies("JSESSIONID").logoutSuccessUrl(LOGIN_URL).and()
						.oauth2Login()
						.defaultSuccessUrl("/oauth2/loginsuccess",true)
						.and()
						.logout(logout -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()))
						.csrf().disable()
						.addFilterAfter(csrfFilter(patterns), FilterSecurityInterceptor.class)
						.addFilterAfter(new CsrfGrantingFilter(), CsrfFilter.class);
			
			}
			private Filter csrfFilter(String[] patterns) {
			    CsrfFilter csrfFilter = new CsrfFilter(csrfTokenRepository());
			    csrfFilter.setRequireCsrfProtectionMatcher(csrfProtectionMatcher(patterns));
			    return csrfFilter;
			}
			
			private NoAntPathRequestMatcher csrfProtectionMatcher(String[] patterns) {
			    return new NoAntPathRequestMatcher(patterns);
			}
			
			private CsrfTokenRepository csrfTokenRepository() {
			    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
			    repository.setHeaderName("X_XSRF_TOKEN");
			    return repository;
			}
	}
	
	private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler = new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);

        oidcLogoutSuccessHandler.setPostLogoutRedirectUri(URI.create("https://localhost:9443"));

        return oidcLogoutSuccessHandler;
    }

}