package ApiGateway.com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.server.mvc.config.GatewayMvcProperties.HttpClient;
import org.springframework.context.annotation.Bean;

import io.netty.resolver.DefaultAddressResolverGroup;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
//	@Bean
//	public HttpClient httpClient() {
//	    return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
//	}

}