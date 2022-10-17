package com.Auth.Security;

import com.Auth.Filters.JWTAuthorizationFilter;
import com.Auth.Filters.JWTauthenticationFilter;
import com.Auth.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected  void configure(AuthenticationManagerBuilder auth)throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/login/**","/role/**","/register/**","/actived/**")
                .permitAll();
        http.authorizeRequests().antMatchers("/role/**").hasAuthority("Admin");

        http.authorizeRequests().antMatchers("/Produits/**","/ajtProduits/**","/listProduitPayment/**","/usersToPayment/**"
                ,"/usersFromPayment/**","/createPayment/**").hasAuthority("User");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTauthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
