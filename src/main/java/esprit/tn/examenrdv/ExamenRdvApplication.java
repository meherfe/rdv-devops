package esprit.tn.examenrdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class ExamenRdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenRdvApplication.class, args);
	}

}
