package pl.polsl.rtc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import pl.polsl.rtc.dao.StreamRepository;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.Stream;
import pl.polsl.rtc.entity.User;

import java.util.Arrays;

@Configuration
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("administrator"));
        userRepository.save(user);

        Stream stream = new Stream();
        stream.setName("USA Highway");
        stream.setDescription("The Highway in USA with bridge view");
        stream.setUrl("http://69.51.121.170:80/mjpg/video.mjpg?COUNTER");
        streamRepository.save(stream);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean(name = "CORS Filter")
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // config.addAllowedOrigin("http://localhost:4200");
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin",
                "Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control",
                "Content-Type", "Authorization"));
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");

//        log.debug("Registering CORS filter");
        source.registerCorsConfiguration("/api/**", config);
        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
