package app;


import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;
=======
>>>>>>> master
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

<<<<<<< HEAD
@Configuration
=======
>>>>>>> master
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
<<<<<<< HEAD
                .antMatchers("/", "/home", "/user-creation").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
=======
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user-creation").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error");
>>>>>>> master
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
<<<<<<< HEAD

        auth
                .inMemoryAuthentication()
                .withUser("Me").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("not me").password("password").roles("USER");
=======
>>>>>>> master
    }
}
