package cv.pn.equipament.dtos;

import lombok.Data;

@Data
public class SearchEquipmentDTO {

    private String nameEquipment;
    private String equipmentType;
    private String nameEmployee;
    private String room;
    private String department;
    private String brand;

}
