package com.example.aprovechapp.security;

import com.example.aprovechapp.service.AdministradorService;
import com.example.aprovechapp.service.impl.AdministradorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

    @Autowired
    public AdministradorServiceImpl administradorServiceImpl;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(administradorServiceImpl)
                .passwordEncoder(new BCryptPasswordEncoder());
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/registro").permitAll()
                .requestMatchers("/registro-verduleria").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                .and().csrf().disable();

        return http.build();
    }
//.csrf(csrf -> csrf
//
//            .disable())
//
//            .authorizeHttpRequests(authRequest -> authRequest
//
//            .requestMatchers("/auth/**").permitAll()
//
//                                                .requestMatchers("/admin/**").hasRole("ROLE_ADMINISTRADOR")
//
//                                                .anyRequest().authenticated())
//
//
//
//
//            return http
//
//            .csrf(csrf -> csrf
//
//            .disable())
//
//            .authorizeHttpRequests(authRequest -> authRequest
//
//            .requestMatchers("/auth/**").permitAll()
//
//                                                .requestMatchers("/admin/**").hasRole("ROLE_ADMINISTRADOR")
//
//                                                .anyRequest().authenticated())
//
//            .sessionManagement(sessionManager -> sessionManager
//
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//
//            .authenticationProvider(authProvider)
//
//                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//
//                                .build;



}
