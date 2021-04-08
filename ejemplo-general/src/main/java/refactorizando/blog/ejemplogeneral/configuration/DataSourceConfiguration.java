package refactorizando.blog.ejemplogeneral.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import refactorizando.blog.ejemplogeneral.constants.Constants;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean(name = Constants.DATASOURCE_NAME)
    @ConfigurationProperties(prefix = Constants.PREFIX_MAIN_DATASOURCE)
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = Constants.LIQUIBASE_PROPERTIES_NAME)
    @ConfigurationProperties(prefix = Constants.PREFIX_MAIN_CHANGELOG)
    public LiquibaseProperties getLiquibaseProperties(){
        return new LiquibaseProperties();
    }

    @Bean(name = Constants.SPRING_LIQUIBASE)
    public SpringLiquibase liquibaseConfiguration(){
        return configureLiquibase(getDataSource(),getLiquibaseProperties());
    }

    public SpringLiquibase configureLiquibase(DataSource dataSource,LiquibaseProperties liquibaseProperties){
        SpringLiquibase springLiquibase=new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog(liquibaseProperties.getChangeLog());
        return springLiquibase;

    }




}
