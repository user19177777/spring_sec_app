package com.example.spring_sec_app.config;

import com.example.spring_sec_app.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthProviderImpl authProvider;
@Autowired
    public SecurityConfig(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authProvider);
    }
}
