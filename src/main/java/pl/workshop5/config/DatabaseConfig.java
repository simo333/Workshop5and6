package pl.workshop5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("pl.workshop5.config")
public class DatabaseConfig {
    private static final String MY_SQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop5";
    private static final String DB_ROOT = "root";
    private static final String DB_PASSWORD = "root";

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(MY_SQL_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_ROOT);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }
}
