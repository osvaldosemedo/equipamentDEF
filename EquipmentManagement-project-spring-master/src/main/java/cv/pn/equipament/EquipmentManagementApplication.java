package cv.pn.equipament;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@OpenAPIDefinition
public class EquipmentManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentManagementApplication.class, args);
	}

}
