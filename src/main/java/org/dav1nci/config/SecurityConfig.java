package org.dav1nci.config;

import org.dav1nci.dbservice.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by dav1nci on 03.11.15.
 */
/*@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)*/
public class SecurityConfig //extends WebSecurityConfigurerAdapter
{

   /* @Bean(name = "userDetailsService")
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // регистрируем нашу реализацию UserDetailsService
    // а также PasswordEncoder для приведения пароля в формат SHA1


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                        // указываем action с формы логина
                .loginProcessingUrl("/j_spring_security_check")
                        // указываем URL при неудачном логине
                .failureUrl("/login?error")
                        // Указываем параметры логина и пароля с формы логина
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                        // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                        // указываем URL логаута
                .logoutUrl("/logout")
                        // указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                        // делаем не валидной текущую сессию
                .invalidateHttpSession(true);

    }*/
}
