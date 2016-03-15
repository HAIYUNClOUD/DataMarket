package org.summer.dp.cms;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
	@Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(simpleCORSFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("simpleCORSFilter");
        return registration;
    }

    @Bean(name = "simpleCORSFilter")
    public Filter simpleCORSFilter() {
        return new SimpleCORSFilter();
    }
}
