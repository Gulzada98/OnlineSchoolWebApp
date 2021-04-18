package org.itstep.webApp.config;

import org.itstep.webApp.service.EmployeeService;
import org.itstep.webApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private StudentService studentService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.exceptionHandling().accessDeniedPage("/accessdenied");

    http
        .authorizeRequests()
        .antMatchers("/css/**", "/js/**").permitAll()
        .antMatchers("/").permitAll();

    http.formLogin()
        .loginProcessingUrl("/auth").permitAll()
        .loginPage("/login").permitAll()
        .usernameParameter("email")
        .passwordParameter("password")
        .successForwardUrl("/")
        .defaultSuccessUrl("/")
        .failureUrl("/login?error");

    http.logout().permitAll()
        .logoutUrl("/auth/logout")
        .logoutSuccessUrl("/login").permitAll();

    //http.csrf().disable();

  }

/*  @Override protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(employeeService);
    auth.userDetailsService(studentService);
  }*/

  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
    return  new BCryptPasswordEncoder();
  }

}
