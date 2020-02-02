package wuhan_hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		/*SpringApplication.run(Application.class, args);*/
		SpringApplication app = new SpringApplication(Application.class);
		app.addListeners(new SampleListener());
		app.run(args);
	}
	
}