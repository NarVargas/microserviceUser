/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemplo.narciso.nvargamu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Nar
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/public").permitAll() // Permitir acceso a rutas específicas sin autenticación
                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                .and()
            .formLogin() // Habilitar el formulario de inicio de sesión por defecto
                .loginPage("/login") // URL de la página de inicio de sesión personalizada
                .permitAll() // Permitir acceso a la página de inicio de sesión sin autenticación
                .and()
            .logout() // Habilitar la funcionalidad de cierre de sesión
                .permitAll(); // Permitir acceso al proceso de cierre de sesión sin autenticación
    }
    
}
