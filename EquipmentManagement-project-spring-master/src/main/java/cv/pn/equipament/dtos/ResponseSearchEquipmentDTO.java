package cv.pn.equipament.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ResponseSearchEquipmentDTO {

    private String id;
    private String nameEquipment;
    private String equipmentType;
    private String nameEmployee;
    private String room;
    private String department;
    //private String brand;
}
