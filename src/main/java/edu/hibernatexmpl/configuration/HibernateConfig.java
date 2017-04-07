package edu.hibernatexmpl.configuration;

import edu.hibernatexmpl.model.Car;
import edu.hibernatexmpl.model.Engine;
import edu.hibernatexmpl.model.Tyre;
import edu.hibernatexmpl.model.Wheel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ImportResource(locations = {"application.yml"})
public class HibernateConfig {

    @Value("${datasource.driverClassName}")
    String driverClassName;
    @Value("${datasource.url}")
    String url;
    @Value("${datasource.username}")
    String username;
    @Value("${datasource.password}")
    String password;
    @Value("${hibernate.dialect}")
    String dialect;

    @Bean
    public DataSource dataSource() {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setAnnotatedClasses(Car.class, Engine.class, Wheel.class, Tyre.class);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
