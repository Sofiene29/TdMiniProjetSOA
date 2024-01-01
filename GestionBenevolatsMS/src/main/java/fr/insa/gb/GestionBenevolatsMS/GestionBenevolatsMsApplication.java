package fr.insa.gb.GestionBenevolatsMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class GestionBenevolatsMsApplication {
	
	@Bean
    @LoadBalanced 
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GestionBenevolatsMsApplication.class, args);
		System.out.println("Application has started!");
	}

}
