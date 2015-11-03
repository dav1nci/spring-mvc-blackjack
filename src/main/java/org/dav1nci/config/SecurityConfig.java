package org.dav1nci.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by dav1nci on 03.11.15.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("anon").password("1").roles("ANON");
        auth.inMemoryAuthentication().withUser("user").password("11").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("111").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll() //not sequried
                .antMatchers("/rules/**").access("hasRole('ROLE_USER')")
                .antMatchers("/faq/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/", false);
                /*.and().exceptionHandling().accessDeniedPage("/Access_Denied");*/
    }
}
