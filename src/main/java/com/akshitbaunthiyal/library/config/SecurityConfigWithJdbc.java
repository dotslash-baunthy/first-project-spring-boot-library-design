package com.akshitbaunthiyal.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigWithJdbc extends WebSecurityConfigurerAdapter {
    
    DataSource dataSource;

    @Autowired
    public SecurityConfigWithJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
                .withUser(User.withUsername("akshit").password(getPasswordEncoder().encode("Captain_007")).roles("LIBRARY_OWNER"))
                .withUser(User.withUsername("ananya").password(getPasswordEncoder().encode("Captain@007")).roles("LIBRARY_CLERK"));
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/create/**", "/delete/**").hasRole("LIBRARY_OWNER")
                .antMatchers("/exist/**", "/read/**").hasAnyRole("LIBRARY_OWNER", "LIBRARY_CLERK")
                .antMatchers("/").permitAll().and().formLogin();
    }
}
