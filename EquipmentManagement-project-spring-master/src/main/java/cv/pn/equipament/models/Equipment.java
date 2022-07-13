package cv.pn.equipament.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "equipment")
@Entity
public class Equipment extends CommonsAttributes {

    @Column(name = "name", nullable = true, columnDefinition = "character varying(100)")
    private String name;

    @Column(name = "brand", nullable = true, columnDefinition = "character varying(40)")
    private String brand;

    @Column(name = "model", nullable = true, columnDefinition = "character varying(40)")
    private String model;

    @Column(name = "serial_number", nullable = true, columnDefinition = "character varying(100)")
    private String serialNumber;

    @Column(name = "processor", nullable = true, columnDefinition = "character varying(40)")
    private String processor;

    @Column(name = "rom", nullable = true, columnDefinition = "character varying(40)")
    private String rom;

    @Column(name = "ram", nullable = true, columnDefinition = "character varying(40)")
    private String ram;

    @Column(name = "generation", nullable = true, columnDefinition = "character varying(40)")
    private String generation;

    @Column(name = "velocity", nullable = true, columnDefinition = "character varying(40)")
    private String velocity;

    @Column(name = "system_type", nullable = true, columnDefinition = "character varying(40)")
    private String systemType;

    @Column(name = "dm_State_Epuip", nullable = true, columnDefinition = "character varying(40)")
    private String dmStateEquip;

    @Column(name = "screen", nullable = true, columnDefinition = "character varying(40)")
    private String screen;

    @Column(name = "obs", nullable = true, columnDefinition = "character varying(40)")
    private String obs;

    @ManyToOne
    @JoinColumn(name = "id_sala",  referencedColumnName = "id",  updatable=false)
    @JsonBackReference
    private  LivingRoom livingRoom;

    @ManyToOne
    @JoinColumn(name = "id_user",  referencedColumnName = "id",  updatable=false)
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_equipmentType",  referencedColumnName = "id",  updatable=false)
    @JsonBackReference
    private  EquipmentType equipmentType;


}
