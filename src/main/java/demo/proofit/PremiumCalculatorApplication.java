package demo.proofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Entry class for PremiumCalculatorApplication
 *
 */

@SpringBootApplication
public class PremiumCalculatorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PremiumCalculatorApplication.class);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(PremiumCalculatorApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}
}
