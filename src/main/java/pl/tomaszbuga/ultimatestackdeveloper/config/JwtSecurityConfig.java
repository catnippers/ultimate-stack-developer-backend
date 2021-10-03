package pl.tomaszbuga.ultimatestackdeveloper.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pl.tomaszbuga.ultimatestackdeveloper.auth.JwtAuthenticationEntryPoint;
import pl.tomaszbuga.ultimatestackdeveloper.auth.JwtAuthenticationProvider;
import pl.tomaszbuga.ultimatestackdeveloper.auth.JwtAuthenticationTokenFilter;
import pl.tomaszbuga.ultimatestackdeveloper.auth.JwtSuccessHandler;

import java.util.Arrays;
import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // for production environment please use
        // configuration.setAllowedOrigins(Collections.singletonList("https://ultimatestackdeveloper.netlify.app"));

        // for development environment please use
        // configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedOrigins(Collections.singletonList("*"));

        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Collections.singletonList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //first 3 methods force HTTPS on Heroku
        http.requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure()
                .and()
                .cors()
                .and().
                csrf().disable()
                .authorizeRequests().antMatchers("**/graphql/**").permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }
}
