package pe.com.cibertec.ProyectoPolleriaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProyectoPolleriaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPolleriaAppApplication.class, args);
	}

}
