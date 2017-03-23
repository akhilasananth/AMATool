package app;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * Created by joelprakash on 3/5/2017.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of users
            User user = new User("Me", "Jonathan");
            user.addAMAToUserList(new AMA("testAMA"));
            user.addAMAToUserList(new AMA("testAMA2"));
            repository.save(user);
            repository.save(new User("not me", "Bob"));

            log.info("Users from findAll(): ");
            log.info("---------------------------");

            for(User u: repository.findAll()){
                log.info(u.toString());
            }
        };
    }


    @Bean
    public CommandLineRunner demoAMA(AMARepository repository) {
        return (args) -> {
            // save a couple of AMAs
            ArrayList<String> keywords = new ArrayList<String>();
            keywords.add("new");
            keywords.add("shiny");
            repository.save(new AMA("something", keywords));
            ArrayList<String> keywords2 = new ArrayList<String>();
            keywords2.add("smth");
            keywords2.add("else");
            repository.save(new AMA("second", keywords));

            log.info("AMAs from findAll(): ");
            log.info("---------------------------");
            for(AMA ama: repository.findAll()){
                log.info(ama.toString());
            }
        };
    }
}

