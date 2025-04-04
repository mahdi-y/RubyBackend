package fd.assignment;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll() // Permit all requests without authentication
                .anyRequest().authenticated(); // Optional: Any other request requires authentication

        // Optional: Disable form login
        http.formLogin().disable();

        // Optional: Disable HTTP Basic authentication
        http.httpBasic().disable();
    }
}
