package EurekaCopy.com.service.EurekaCopyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCopyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCopyserviceApplication.class, args);
	}

}
