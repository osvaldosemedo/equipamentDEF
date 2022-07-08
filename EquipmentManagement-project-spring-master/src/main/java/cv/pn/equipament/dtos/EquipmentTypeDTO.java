package cv.pn.equipament.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentTypeDTO {
    private  String id;
    private String name;
    private String code;
    private String selfId;

}
