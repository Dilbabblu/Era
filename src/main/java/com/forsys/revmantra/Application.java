package com.forsys.revmantra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.forsys.revmantra.filter.CORSFilter;

@Configuration
@Import({ RepositoryRestMvcConfiguration.class })
@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync(proxyTargetClass = true)
@EnableCaching
@EnableScheduling
public class Application {
	@Autowired
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("Running Application!!!");
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<CORSFilter> commonsRequestLoggingFilter() {
		FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new CORSFilter());
		return registrationBean;
	}
}
