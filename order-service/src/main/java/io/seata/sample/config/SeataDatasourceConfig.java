package io.seata.sample.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SeataDatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariDataSource hikariDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(HikariDataSource hikariDataSource) {
        return new DataSourceProxy(hikariDataSource);
    }
}
