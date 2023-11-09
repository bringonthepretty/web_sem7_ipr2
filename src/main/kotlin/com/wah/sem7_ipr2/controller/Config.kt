package com.wah.sem7_ipr2.controller

import com.wah.sem7_ipr2.model.Role
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@Configuration
@EnableWebSecurity
class Config {

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.authorizeHttpRequests {
            it.requestMatchers("/auth").permitAll()
            it.requestMatchers(HttpMethod.GET,"/room", "/room/{id}").hasAnyAuthority(Role.USER.name, Role.ADMIN.name)
            it.requestMatchers(HttpMethod.POST,"/room/{id}/reserve").hasAnyAuthority(Role.USER.name, Role.ADMIN.name)
            it.anyRequest().hasAuthority(Role.ADMIN.name)
        }.csrf {
            it.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        }.oauth2Login(Customizer.withDefaults())

        return httpSecurity.build()
    }

}