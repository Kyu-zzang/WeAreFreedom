package io.github.weAreFreedom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> {
                    requests.antMatchers("/", "/h2-console/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .headers(httpSecurityHeadersConfigurer -> {
                    httpSecurityHeadersConfigurer.frameOptions().disable();
                })
                .formLogin(form -> {
                    form.loginPage("/login").permitAll();
                })
                .logout(logout -> {
                    logout.permitAll();
                });
        return http.build();
    }

}
