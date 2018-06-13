package com.mcs.pmay.config;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author chandrakumar
 *
 */
@Configuration
@ConfigurationProperties("mysql")
public class DBConfigFrMySQL {

	    @NotNull
	    private String username;
	    @NotNull
	    private String password;
	    @NotNull
	    private String url;
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public void setUrl(String url) {
	        this.url = url;
	    }
	    @Bean
	    DataSource dataSource() {
	        MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setUser(username);
	        dataSource.setPassword(password);
	        dataSource.setURL(url);
	        dataSource.setFailOverReadOnly(true);
	        return dataSource;
	    }
}
