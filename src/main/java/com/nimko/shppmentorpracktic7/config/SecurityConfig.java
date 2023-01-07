package com.nimko.shppmentorpracktic7.config;


import com.nimko.shppmentorpracktic7.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.PUT).authenticated()
                .antMatchers(HttpMethod.DELETE).hasAuthority(Role.ADMIN.name())
                .and()
                .httpBasic()
                ;
    }

    @Autowired
    AuthenticationProvider provider;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(provider)
                /*
                .inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .authorities(Role.USER.name())
                .and()
                .withUser("admin")
                .password("admin")
                .authorities(Role.ADMIN.name())

                 */
                ;

    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
