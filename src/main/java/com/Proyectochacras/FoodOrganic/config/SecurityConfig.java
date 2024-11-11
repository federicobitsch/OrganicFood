package com.Proyectochacras.FoodOrganic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .requestMatchers("/web/index.html", "/web/js/**", "/web/css/**", "/web/img/**").permitAll()  // Rutas estáticas
                        .requestMatchers("/api/public/**").permitAll()  // Si tienes APIs públicas
                        .requestMatchers("/api/catalogo/**").permitAll()  // Rutas del catálogo que no requieren autenticación
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Solo ADMIN puede acceder a /admin/**
                        .requestMatchers("/clientes/**").hasRole("CLIENTE")  // Solo CLIENTE puede acceder a /clientes/**
                        .anyRequest().authenticated()  // Requiere autenticación para cualquier otra ruta
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login personalizada
                        .defaultSuccessUrl("/publicaciones", true)  // Redirección después de login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());  // Desactiva CSRF si es necesario
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
