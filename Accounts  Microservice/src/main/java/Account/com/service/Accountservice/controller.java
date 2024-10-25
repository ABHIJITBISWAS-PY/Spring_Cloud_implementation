package Account.com.service.Accountservice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.sun.org.slf4j.internal.LoggerFactory;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping("/account")
public class controller {
	
	@Autowired
	public serviceClass serviceclass;
	
	@Autowired
	public customerServiceProxyFeign customerServiceProxy;

//	public java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log");
	org.slf4j.Logger log =LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
	public String myName(@RequestParam (required = false, defaultValue = "1")int a) {
		System.out.println("Accountservice");
		return serviceclass.name();
	}
	
	@GetMapping(value = "/api/feign", produces = MediaType.APPLICATION_JSON_VALUE)
	@Retry(name = "default")
	public String acntServiceApiCallingUsingfeign(@RequestParam (required = false, defaultValue = "1")int a) {

		return customerServiceProxy.gettingName(a);
	}
	
	@PutMapping(value = "/api/retry", produces = MediaType.APPLICATION_JSON_VALUE)
	@Retry(name = "retryConfig", fallbackMethod = "fallBackMethodName")
	public String reTryMethod(@RequestParam (required = false, defaultValue = "1")int a) {

		log.info("retry");
		new RestTemplate().getForEntity("http://localhost:300/api", controller.class);
		
		return "a";
	}
	
	@PostMapping (value = "/api/circuit", produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "AccountCircuit", fallbackMethod = "fallBackMethodName")
	public String circuitbreakerMethod(@RequestParam (required = false, defaultValue = "1")int a) {

		log.info("circuit");
		new RestTemplate().getForEntity("http://localhost:300/api", controller.class);
		
		return "a";
	}
	
	public String fallBackMethodName(int a, Exception e) {
		return "fallBackMethod Triggered";
	}
	

}
