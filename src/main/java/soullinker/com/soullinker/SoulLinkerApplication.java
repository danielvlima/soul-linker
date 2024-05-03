package soullinker.com.soullinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SoulLinkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoulLinkerApplication.class, args);
	}

}
