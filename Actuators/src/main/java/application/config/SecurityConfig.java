package application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//          auth.inMemoryAuthentication()
//          .withUser("user").password("{noop}password").roles("USER") .and()
//          .withUser("admin").password("{noop}password").roles("ADMIN");
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http 
//            .csrf() 
//            .disable()
//            .authorizeRequests()
//            .antMatchers("/", "/home","/guest").permitAll() 
//            .antMatchers("/admin/**").hasAnyRole("ADMIN")
//            .antMatchers("/user/**").hasAnyRole("USER")
//            .anyRequest().authenticated();
//    }
//}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = 
//          PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth
//          .inMemoryAuthentication()
//          .withUser("user")
//          .password(encoder.encode("password"))
//          .roles("USER")
//          .and()
//          .withUser("bob")
//          .password(encoder.encode("password123"))
//          .roles("USER", "ADMIN", "ACTUATOR");
//    }   
    
    @Override
    protected void configure ( HttpSecurity http ) throws Exception
    {
        http.authorizeRequests ().mvcMatchers ( "/actuator/health", "actuator/info" ).permitAll ()
                                                .mvcMatchers ( "/actuator/**" )
                                                //.hasRole ( "ACTUATOR" )
                                                //.anyRequest ()
                                                .authenticated ();
    }
}
