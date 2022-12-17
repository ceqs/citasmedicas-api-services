package pe.edu.utp.soa.citasmedicas.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/v1/**")
                .hasAuthority("SCOPE_write")
                .antMatchers(HttpMethod.GET, "/v1/**")
                .hasAuthority("SCOPE_read")
            .anyRequest()
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt();

        /*
        http.headers().cacheControl();
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/v1/**").permitAll()
                .antMatchers("/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        */

        return http.build();
    }

}