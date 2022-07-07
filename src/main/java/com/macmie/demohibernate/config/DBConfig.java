package com.macmie.demohibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DBConfig {
    // Quản lý kết nối Database
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/demo_hibernate");
        dataSource.setPassword("macmie");
        dataSource.setUsername("root");
        return dataSource;
    }

    // Kết nối với CSDL và tạo các Sessions cho phép mở kết nối và query tới CSDL
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        // Set datasource cho SessionFactory
        bean.setDataSource(dataSource());
        // Khai báo package chứa các Entities mapping với các bảng trong CSDL
        bean.setPackagesToScan("com.macmie.demohibernate.entity");

        Properties properties = new Properties();
        // Chỉ định loại SQL đích để Hibernate biên dịch ra các lệnh phù hợp với CSDL
        properties.put("hibernate.dialect.MySQLDialect", properties);
        // Cho phép in lệnh queries trong console
        properties.put("hibernate.show_sql", true);
        // Format các câu queries truy vấn in trong console
        properties.put("hibernate.format_sql", true);

        bean.setHibernateProperties(properties);
        return bean;
    }
}
