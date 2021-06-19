package com.emmanuelagboola.daofab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.emmanuelagboola.daofab.interfaces.TransactionProjection;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyConfiguration implements RepositoryRestConfigurer {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    	config.getProjectionConfiguration()
          .addProjection(TransactionProjection.class);
    }

    
}
