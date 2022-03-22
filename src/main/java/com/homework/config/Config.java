package com.homework.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.homework.entity.User;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.homework" })
@EnableTransactionManagement
public class Config implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSession = new LocalSessionFactoryBean();
		localSession.setDataSource(getDataSource());
		localSession.setPackagesToScan("com.homework.entity");
		localSession.setAnnotatedClasses(User.class);
		// localSession.setAnnotatedClasses(Role.class);
		localSession.setHibernateProperties(getHibernateProperties());
		return localSession;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("hibernate.connection.pool_size", "20");

		return hibernateProperties;
	}

//?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/Human");
		dataSource.setUsername("root");
		dataSource.setPassword("arif12345678arif");

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		return dataSource;
	}

//@Bean
//@Autowired
//public HibernateTransactionManager getTransection(SessionFactory sessionFactory123) {
//	HibernateTransactionManager hibernateTransection = new HibernateTransactionManager(sessionFactory123);
//	return hibernateTransection;
//}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/UrlToResourceFolder/**").addResourceLocations("/resources/");

	}

}
