package pl.polsl.rtc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.polsl.rtc.dao.StreamRepository;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.Stream;
import pl.polsl.rtc.entity.User;

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
}
