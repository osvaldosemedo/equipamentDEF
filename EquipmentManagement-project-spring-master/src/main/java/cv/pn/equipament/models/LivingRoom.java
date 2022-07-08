package cv.pn.equipament.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="livinRoom")
public class LivingRoom extends CommonsAttributes{

    @Column(name = "name", nullable = true, columnDefinition = "character varying(100)")
    private String name;

    @Column(name = "number", nullable = true, columnDefinition = "character varying(40)")
    private String number;

    @Column(name = "dm_piso", nullable = true, columnDefinition = "character varying(100)")
    private String dmPiso;

    @Column(name = "dm_Division", nullable = true, columnDefinition = "character varying(40)")
    private String dmDivision;

    @Column(name = "contact_phone", nullable = true, columnDefinition = "character varying(40)")
    private String contactPhone;

    @ManyToOne
    @JoinColumn(name = "id_department",  referencedColumnName = "id",  updatable=false)
    @JsonBackReference
    private  Department department;






}
