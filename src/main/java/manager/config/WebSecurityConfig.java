/*package manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/manager").permitAll()
                .mvcMatchers("customer").permitAll()
                .and()
                .formLogin()

                .and().httpBasic();

    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("dtuan").password("54321").roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}



 */

