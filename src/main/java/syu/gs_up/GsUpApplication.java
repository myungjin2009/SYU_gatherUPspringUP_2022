package syu.gs_up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GsUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsUpApplication.class, args);
	}

}
