package com.learn.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    // Below method is used for saving inMemory user
    // public interface UserDetailsService has loadUserByUserName method, we are returning the object of InMemoryUserDetailsManager
    //public class InMemoryUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService
    // InMemoryUserDetailsManager has two Users -> User1 & User2
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User.builder().username("ABC").password(passwordEncoder().encode("ABC")).roles("Admin").build();
        UserDetails user2 = User.builder().username("XYZ").password(passwordEncoder().encode("XYZ@12")).roles("User").build();
        return new InMemoryUserDetailsManager(user1, user2);

        // InMemoryUserDetailsManager method accepts Variable number of arguments.
        // UserDetails is a serializable interface.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
