package com.example.microservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableResourceServer
public class Application {
	
	@LoadBalanced
    @Bean
    public OAuth2RestTemplate getOAuth2RestTemplate(OAuth2ClientContext auth2ClientContext) {
        return new OAuth2RestTemplate(customOauth2RemoteResource(), auth2ClientContext);
    }
    
  
   
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean
	public OAuth2ClientContext auth2ClientContext() { 
		DefaultOAuth2ClientContext context = new DefaultOAuth2ClientContext();
		return context;
	}
	
	@Bean
	@ConfigurationProperties("security.oauth2.client")
	public ClientCredentialsResourceDetails customOauth2RemoteResource() {
	    ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
	    return details;
	}
	
	
	
	
	 
	
	
	
}
