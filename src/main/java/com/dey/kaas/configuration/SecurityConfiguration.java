package com.dey.kaas.configuration;

import com.dey.kaas.entiity.ROLE;
import com.dey.kaas.filter.JwtFilter;
import com.dey.kaas.service.CustomeUserDetailsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    JwtFilter filter;

    public SecurityConfiguration(JwtFilter filter) {
        this.filter = filter;
    }

    @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.cors(cust -> cust.disable())
		.csrf(cust -> cust.disable())
		.authorizeHttpRequests(request -> request.requestMatchers("login/**","register/**").permitAll()
                .requestMatchers("/action/**","/companies/**").hasAnyAuthority(ROLE.ROLE_SUPER_ADMIN.name(), ROLE.ROLE_ADMIN.name())
                .requestMatchers("/resources/types/**", "/resources/**","/accesses/**","/accessGroups/**","/users/**").hasAnyAuthority(ROLE.ROLE_SUPER_ADMIN.name(), ROLE.ROLE_ADMIN.name(), ROLE.ROLE_COMPNAY_ADMIN.name())
				.anyRequest().authenticated())
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
		.build();
	}

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider(CustomeUserDetailsService userDetailsService){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider(userDetailsService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

}
