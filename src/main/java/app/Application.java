package app;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
            Date date=new Date();
            AMA ama1=new AMA("testAMA1");
            AMA ama2=new AMA("testAMA2");
            AMA ama3=new AMA("testAMA3");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR_OF_DAY, 1);
            date = cal.getTime();
            ama1.setDeadlineToVote(date);
            ama2.setDeadlineToVote(new Date(12/01/1999));
            //ama3.setDeadlineToVote(Calendar.getInstance().getTime());
            user.addAMAToUserList(ama1);
            user.addAMAToUserList(ama2);
            user.addAMAToUserList(ama3);
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

