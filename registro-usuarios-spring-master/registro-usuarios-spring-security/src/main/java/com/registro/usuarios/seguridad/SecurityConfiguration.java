package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.servicio.UsuarioServicio;

/*
 * @Configuration :Anotación encargada de definir que la clase es una clase de configuración para el framework.
 * @Bean :Anotación que marca como bean cada uno de los métodos de tal forma que esten disponibles para Spring.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/*
	 * Inyección de dependencias:
	 * @Autowired: marca un método Constructor, Setter, Propiedades y Config() como autocableado que está 'inyectando beans' (Objetos) en tiempo 
     * de ejecución mediante el mecanismo Spring Dependency Injection.
	 */
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	/*
	 * Método que encripta la contraseña.
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * Método que obtiene infomarción del usuario.
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio); //Obtiene información del usuario.
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	/*
	 * Valida los datos obtenidos con el método authenticationProvider.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider()); 
	}
	
	/*
	 * Método que valida los request, lo que puede entrar a las rutas.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registro**",
				"/js/**",
				"/css/**",
				"/img/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
}






