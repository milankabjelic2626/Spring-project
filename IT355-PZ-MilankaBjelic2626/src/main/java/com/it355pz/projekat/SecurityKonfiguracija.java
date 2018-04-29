package com.it355pz.projekat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityKonfiguracija extends WebSecurityConfigurerAdapter
{


    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/prijavljivanje").permitAll()
                .antMatchers("/registracija").permitAll()
                .antMatchers("/proizvod/**").permitAll()
                .antMatchers("/administrator/**").hasAuthority("ROLA_ADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/prijavljivanje")
                .defaultSuccessUrl("/")
                .usernameParameter("korisnickoIme")
                .passwordParameter("lozinka")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/odjavljivanje"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/zabranjenpristup");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/Css/**", "/js/**", "/Slike/**", "/webjars/**");
    }
}
