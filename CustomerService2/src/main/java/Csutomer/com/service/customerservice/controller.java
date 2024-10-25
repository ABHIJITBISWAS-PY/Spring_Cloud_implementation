package Csutomer.com.service.customerservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	@GetMapping (value= "/api/getName")
	public String gettingName (@RequestParam (required = false, defaultValue = "1")int a) {
		String b = "test Open Feign";
		return b;
	}

}
