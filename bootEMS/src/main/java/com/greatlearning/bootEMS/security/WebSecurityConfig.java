package com.greatlearning.bootEMS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.bootEMS.empservice.UserDetailServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/h2-console/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             // any role user can access these APIs
            .antMatchers("/","/employees/emp_id","/employees/update","/employees/search_firstNmae",
            		     "/employees/sorted_list","/roles/addRole","/users/addUser")
            .hasAnyAuthority("USER","ADMIN","CLERK")
            // only ADMIN's role user authorized to add and delete record from DB
            .antMatchers("/employees/save","/employees/delete").hasAuthority("ADMIN")
            .antMatchers("/error").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list").permitAll()
            .and()
            .logout().logoutSuccessUrl("/login").permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/employees/abc")
            .and()
            .cors().and().csrf().disable();
    }


}
