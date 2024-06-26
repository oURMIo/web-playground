package com.home.web.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        TODO finish method
        http
            .authorizeHttpRequests { request ->
                request.anyRequest().permitAll()
//                request.requestMatchers("/").permitAll()
//                request.requestMatchers("/api/users").hasRole("ADMIN")
//                request.anyRequest().authenticated()
            }
            .csrf { csrf ->
                /* Disables protection against CSRF attacks */
                csrf.disable()
            }

        return http.build()
    }
}
