package ru.league.academy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class AppConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/league_db");
        ds.setUsername("admin");
        ds.setPassword("qwerty$4");
        return ds;
    }

    @Bean
    public SpringLiquibase springLiquibase(){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:/db/changelog-master.yaml");
        return liquibase;
    }

}
