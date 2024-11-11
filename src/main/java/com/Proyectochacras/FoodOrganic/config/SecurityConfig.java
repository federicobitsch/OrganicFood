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
                        .requestMatchers("/**").permitAll()  // Permite todo el acceso a cualquier ruta
                )
                .csrf(csrf -> csrf.disable())  // Deshabilita CSRF
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login personalizada (si la tienes)
                        .permitAll()  // Permite acceso a la página de login sin autenticación
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")  // Redirige a login después de logout
                        .permitAll()  // Permite acceso a la página de logout sin autenticación
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
