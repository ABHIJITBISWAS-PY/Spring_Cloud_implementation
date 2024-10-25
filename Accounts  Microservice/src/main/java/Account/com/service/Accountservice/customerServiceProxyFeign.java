package Account.com.service.Accountservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customerservice", url = "localhost:8080")
public interface customerServiceProxyFeign {
	
	@GetMapping (value= "/api/getName")
	public String gettingName (@RequestParam (required = false, defaultValue = "1")int a);

}
