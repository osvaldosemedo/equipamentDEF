package cv.pn.equipament.utilities;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder @Data
public class APIResponse {
	
	private Boolean status;
	
	private String statusText;
	
	private List<Object> details;
	
	private final LocalDateTime  timeStamp = LocalDateTime.now();

}
