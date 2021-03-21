package refactorizando.blog.ejemplogeneral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"refactorizando.blog"})
public class EjemploGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploGeneralApplication.class, args);
	}

}
