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
        user.setPassword(passwordEncoder.encode("1qazXSW@"));
        user.setAuthority("ROLE_ADMIN");
        userRepository.save(user);

        Stream stream = new Stream();
        stream.setName("USA Highway");
        stream.setDescription("The Highway in USA with bridge view");
        stream.setUrl("http://69.51.121.170:80/mjpg/video.mjpg?COUNTER");
        streamRepository.save(stream);

        Stream stream1 = new Stream();
        stream1.setName("Road in Poznan");
        stream1.setDescription("Road in Polish City");
        stream1.setUrl("http://fowo11.ddns3-instar.de:80/cgi-bin/hi3510/mjpegstream.cgi?-chn=11&-usr=gast&-pwd=storchennest");
        streamRepository.save(stream1);

        Stream stream2 = new Stream();
        stream2.setName("Polish road Warsaw");
        stream2.setDescription("Road in capital of Poland");
        stream2.setUrl("http://78.11.13.243:80/GetData.cgi?CH=1");
        streamRepository.save(stream2);

        Stream stream3 = new Stream();
        stream3.setName("Bird kids");
        stream3.setDescription("Some small birds");
        stream3.setUrl("http://94.42.196.47:80/GetData.cgi?CH=1");
        streamRepository.save(stream3);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
