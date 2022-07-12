package cv.pn.equipament.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentDTO {
    private String id;
    private String name;
    private String model;
    private String serialNumber;
    private String processor;
    private String rom;
    private String ram;
    private String generation;
    private  String velocity;
    private  String systemType;
    private String dmStateEquip;
    private  String screen;
    private String obs;
    private String idEquipmentType;
    private String idLivingRoom;
    private String idEmployee;






}
