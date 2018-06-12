package pl.polsl.rtc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

    private TokenProvider tokenProvider;

    public JWTConfigurer(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }


    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JWTAuthorizationFilter jwtFilter = new JWTAuthorizationFilter(tokenProvider);
        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
