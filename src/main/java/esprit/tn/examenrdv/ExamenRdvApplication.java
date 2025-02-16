package esprit.tn.examenrdv;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplication
@EnableScheduling
public class ExamenRdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenRdvApplication.class, args);
	}
}

@SpringBootTest
class ExamenRdvApplicationTests {
	@Test
	void contextLoads() {
		assertTrue(true, "Application context should load correctly");
	}
}