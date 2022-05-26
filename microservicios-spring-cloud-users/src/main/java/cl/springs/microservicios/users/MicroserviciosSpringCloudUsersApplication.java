package cl.springs.microservicios.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosSpringCloudUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosSpringCloudUsersApplication.class, args);
	}

}
