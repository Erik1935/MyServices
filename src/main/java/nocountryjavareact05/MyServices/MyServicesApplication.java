package nocountryjavareact05.MyServices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class MyServicesApplication {

	public static void main(String[] args) {
	SpringApplication.run(MyServicesApplication.class, args);

	}

	@Bean
	public WebMvcConfigurer corsMappingConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("https://my-service.vercel.app",
								"http://localhost:5173")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD")
						.maxAge(3600)
						.allowedHeaders("*")
						.exposedHeaders("*");
			}
		};
	}
}
