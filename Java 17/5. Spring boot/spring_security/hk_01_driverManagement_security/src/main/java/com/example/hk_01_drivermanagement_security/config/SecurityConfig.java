package com.example.hk_01_drivermanagement_security.config;

import com.example.hk_01_drivermanagement_security.security.CustomUserDetailsService;
import com.example.hk_01_drivermanagement_security.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/routes", "/api/v1/drivers", "/api/v1/assignments").hasAnyAuthority(Roles.ADMIN.toString())
                .antMatchers(HttpMethod.PUT, "/api/v1/routes/{id}", "/api/v1/drivers/{id}", "/api/v1/assignments/{id}").hasAnyAuthority(Roles.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, "/api/v1/routes/{id}", "/api/v1/drivers/{id}").hasAnyAuthority(Roles.ADMIN.toString())
                .antMatchers("/h2-console/**").permitAll() // Allow access to H2 Console
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**") // Disable CSRF for H2 Console
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .cors()
                .and()
                .csrf().disable(); // Enable frame options for H2 Console
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
