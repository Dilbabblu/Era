package com.forsys.revmantra.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.forsys.revmantra.model.AllTabColumns;
import com.forsys.revmantra.model.RmanContHeader;
import com.forsys.revmantra.model.RmanContTemplate;
import com.forsys.revmantra.model.RmanContTransLines;
import com.forsys.revmantra.model.RmanCurrency;
import com.forsys.revmantra.model.RmanEntities;
import com.forsys.revmantra.model.RmanEntityParameters;
import com.forsys.revmantra.model.RmanEntityParametersV;
import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanFmvRulesDef;
import com.forsys.revmantra.model.RmanFmvRulesDefParaValue;
import com.forsys.revmantra.model.RmanIntfDealDetails;
import com.forsys.revmantra.model.RmanIntfUniqueRecord;
import com.forsys.revmantra.model.RmanLegalEntities;
import com.forsys.revmantra.model.RmanLookupsV;
import com.forsys.revmantra.model.RmanResponsibilities;
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.model.RmanRulesHeader;
import com.forsys.revmantra.model.RmanUserResponsibilities;
import com.forsys.revmantra.model.RmanUsers;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.forsys.revmantra.model")
@PropertySource("classpath:META-INF/application.properties")
@EnableJpaRepositories("com.forsys.revmantra.repositories")
public class WebAppConfig implements RepositoryRestConfigurer {
	
	private static final Logger logger = LogManager.getLogger(WebAppConfig.class);

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSCODE = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	
	private static final String PROPERTY_NAME_FROM_EMAIL = "mail.username";
	private static final String PROPERTY_NAME_MAIL_SERVER_HOST = "mail.host";
	private static final String PROPERTY_NAME_MAIL_SERVER_USERNAME = "mail.username";
	private static final String PROPERTY_NAME_MAIL_SERVER_PASSCODE = "mail.password";
	private static final String PROPERTY_NAME_MAIL_SERVER_PORT = "mail.port";
	
	private static final String PROPERTY_NAME_PROCESS_FILE = "processFile";

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSCODE));

		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	@Bean
	public SpringProcessEngineConfiguration getSpringProcessEngineConfiguration(@Qualifier("dataSourceForActiviti") DataSource dataSourceForActiviti,
            @Qualifier("transactionManagerForActiviti") PlatformTransactionManager transactionManagerForActiviti) {
		SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
		processEngineConfiguration.setTransactionManager(transactionManagerForActiviti);
		processEngineConfiguration
		.setMailServerDefaultFrom(env.getRequiredProperty(PROPERTY_NAME_FROM_EMAIL))
		.setMailServerHost(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_HOST))
		.setMailServerUsername(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_USERNAME))
		.setMailServerPassword(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_PASSCODE))
		.setMailServerPort(Integer.valueOf(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_PORT)))
		.setMailServerUseTLS(true)
		.setDataSource(dataSourceForActiviti)
        .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
        .setAsyncExecutorActivate(true);
		
		return processEngineConfiguration;
	}
	
	@Bean
    public ProcessEngineFactoryBean getProcessEngineFactoryBean(SpringProcessEngineConfiguration processEngineConfiguration) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration);
        return processEngineFactoryBean;
    }
	
	@Bean
	public ProcessEngine createProcessEngine() {
		
		ProcessEngine processEngine = SpringProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
				.setMailServerDefaultFrom(env.getRequiredProperty(PROPERTY_NAME_FROM_EMAIL))
				.setMailServerHost(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_HOST))
				.setMailServerUsername(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_USERNAME))
				.setMailServerPassword(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_PASSCODE))
				.setMailServerPort(Integer.valueOf(env.getRequiredProperty(PROPERTY_NAME_MAIL_SERVER_PORT)))
				.setMailServerUseTLS(true)
				.setDataSource(dataSource())
				.setDatabaseSchemaUpdate(SpringProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE)
				.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment().
    	addClasspathResource(env.getRequiredProperty(PROPERTY_NAME_PROCESS_FILE)).deploy().getId();
        	  
		return processEngine;
	}
	
	
	@Bean
	public RepositoryService repositoryService() {
	try {
		return getProcessEngineFactoryBean(getSpringProcessEngineConfiguration(dataSource(),platformTransactionManager())).getObject().getRepositoryService();
	} catch (Exception e) {
		logger.error(e);
		return null;
	}
	}
	
	@Bean
	public RuntimeService runtimeService() {
		try {
			return getProcessEngineFactoryBean(getSpringProcessEngineConfiguration(dataSource(),platformTransactionManager())).getObject().getRuntimeService();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Bean
	public TaskService taskService() {
		try {
			return getProcessEngineFactoryBean(getSpringProcessEngineConfiguration(dataSource(),platformTransactionManager())).getObject().getTaskService();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	@Bean
	public IdentityService identityService() {
		try {
			return getProcessEngineFactoryBean(getSpringProcessEngineConfiguration(dataSource(),platformTransactionManager())).getObject().getIdentityService();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	
	@Bean
	public HistoryService historyService() {
		try {
			return getProcessEngineFactoryBean(getSpringProcessEngineConfiguration(dataSource(),platformTransactionManager())).getObject().getHistoryService();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}



	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean
				.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		properties.put("hibernate.jdbc.batch_size", 500);
		properties.put("hibernate.order_inserts", true);
		properties.put("hibernate.order_updates", true);
		return properties;
	}

	@Bean
	@Primary
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(RmanContTransLines.class, RmanFmvRulesDef.class, RmanLookupsV.class, RmanCurrency.class,
				RmanFmvRulesDefParaValue.class, RmanLegalEntities.class, RmanRulesHeader.class, RmanUsers.class,
				RmanRuleParameterValue.class, RmanEntityParametersV.class, RmanEntityParameters.class,
				RmanEntities.class, RmanContHeader.class, RmanContTemplate.class, 
				RmanFiscalPeriods.class, RmanResponsibilities.class,  RmanUserResponsibilities.class,
				AllTabColumns.class, RmanIntfUniqueRecord.class, RmanIntfDealDetails.class);
		config.setBasePath("/api");
	}

}