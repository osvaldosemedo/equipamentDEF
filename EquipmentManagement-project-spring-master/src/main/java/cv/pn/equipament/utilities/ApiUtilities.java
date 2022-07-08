package cv.pn.equipament.utilities;

import java.util.Optional;





public class ApiUtilities {
	
	public static <T> Optional<T> checkResource(Optional<T> resource, String message) throws RecordNotFoundException {
        if (!resource.isPresent()) {
            throw new RecordNotFoundException(message);
        }
        return resource;
    }
	

}
