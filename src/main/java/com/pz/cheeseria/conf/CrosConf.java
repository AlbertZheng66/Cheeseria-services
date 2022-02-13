package com.pz.cheeseria.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CrosConf {

    @Bean
    public FilterRegistrationBean cors() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new OncePerRequestFilter() {

            @Override
            protected void doFilterInternal(HttpServletRequest httpRequest,
                                            HttpServletResponse httpResponse,
                                            FilterChain filterChain) throws ServletException, IOException {
                httpResponse.setHeader("Access-Control-Allow-Origin", "*");
                // This allows session cookie to be submitted
                httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
                httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
                httpResponse.setHeader("Access-Control-Max-Age", "3600");
                httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, X-Gravity-Error-Code, SESSION_ID, Authorization");
                filterChain.doFilter(httpRequest, httpResponse);
            }
        });
        return registration;
    }
}
