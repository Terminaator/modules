package paul.liibert.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ModulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModulesApplication.class, args);
	}

}
