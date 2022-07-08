package cv.pn.equipament.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "equipmentType")
public class EquipmentType extends  CommonsAttributes{

    @Column(name = "name", nullable = true, columnDefinition = "character varying(100)")
    private String name;

    @Column(name = "code", nullable = true, columnDefinition = "character varying(40)")
    private String code;

    @Column(name = "selfId", nullable = true, columnDefinition = "character varying(100)")
    private String selfId;

}
