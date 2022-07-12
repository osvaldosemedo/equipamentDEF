package cv.pn.equipament.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


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

    @ManyToOne
    @JoinColumn(name = "id_department",  referencedColumnName = "id",  updatable=false)
    @JsonBackReference
    private  Department department;

}
