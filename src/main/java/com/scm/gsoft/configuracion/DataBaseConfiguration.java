package com.scm.gsoft.configuracion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.scm.gsoft.domain.cxc.Bancos;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
	
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		
//		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		sessionFactoryBean.setPackagesToScan("com.scm.gsoft.domain.cxc");
//		sessionFactoryBean.setHibernateProperties(hibernateProperties());
//		return sessionFactoryBean;
//		
//	}
//	
//	@Bean
//	public DataSource dataSource() {
//		
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/cxc?verifyServerCertificate=false&useSSL=true");
//		dataSource.setUsername("root");
//		dataSource.setPassword("admin"); 	
//		
//		return dataSource;
//		
//	}
//	
//	public Properties hibernateProperties() {
//		
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		properties.put("hibernate.show_sql", "true");
//		
//		return properties;
//	}
//	
//	@Bean
//	@Autowired
//	public HibernateTransactionManager hibernateTransactionManager() {
//		
//		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
//		return hibernateTransactionManager;
//		
//		
//	}
	

	@Primary
	@Bean("invSessionFactory")
	public LocalSessionFactoryBean invSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
		localSessionFactory.setDataSource(dataSource);
		localSessionFactory.setPackagesToScan("com.scm.gsoft.domain.inv");
		localSessionFactory.setHibernateProperties(hibernateProperties());
		return localSessionFactory;
		
		
	}
		
	@Bean("cxcSessionFactory")
	public LocalSessionFactoryBean cxcSessionFactory(@Qualifier("cxcDataSource") DataSource dataSource) {
		
		LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
		localSessionFactory.setDataSource(dataSource);
		localSessionFactory.setPackagesToScan("com.scm.gsoft.domain.cxc");
//		localSessionFactory.setAnnotatedClasses(Bancos.class);
		localSessionFactory.setHibernateProperties(hibernateProperties());
		return localSessionFactory;
		
		
	}
	
	@Primary
	@Bean(name = "invDataSource")
	public DataSource invDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/inv?verifyServerCertificate=false&useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
		
	}
	
	@Bean(name = "cxcDataSource")
	public DataSource cxcDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cxc?verifyServerCertificate=false&useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
		
	}
	
	public Properties hibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
		
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager cxcHibernateTransactionManager(@Qualifier("cxcDataSource") DataSource dataSource) {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(cxcSessionFactory(dataSource).getObject());
		return hibernateTransactionManager;
	}
	
	@Primary
	@Bean
	@Autowired
	public HibernateTransactionManager invHibernateTransactionManager(@Qualifier("invDataSource") DataSource dataSource) {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(invSessionFactory(dataSource).getObject());
		return hibernateTransactionManager;
	}

}
