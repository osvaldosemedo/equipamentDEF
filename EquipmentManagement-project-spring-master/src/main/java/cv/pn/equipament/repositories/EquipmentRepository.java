package cv.pn.equipament.repositories;


import cv.pn.equipament.dtos.ResponseSearchEquipmentDTO;
import cv.pn.equipament.dtos.SearchEquipmentDTO;
import cv.pn.equipament.models.*;
import cv.pn.equipament.utilities.APIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, String>, EquipmentCriteria {
    List<Equipment> findAll();

}

interface EquipmentCriteria{
    List<ResponseSearchEquipmentDTO> searchEquipment(SearchEquipmentDTO search);

}

@Repository
class EquipmentCriteriaImpl implements EquipmentCriteria{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ResponseSearchEquipmentDTO> searchEquipment(SearchEquipmentDTO search) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ResponseSearchEquipmentDTO> criteriaQuery = criteriaBuilder.createQuery(ResponseSearchEquipmentDTO.class);
        Root<Equipment> equipmentRoot = criteriaQuery.from(Equipment.class);
        Root<EquipmentType> equipmentTypeRoot = criteriaQuery.from(EquipmentType.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Root<LivingRoom> livingRoomRoot = criteriaQuery.from(LivingRoom.class);
        Root<Department> departmentRoot = criteriaQuery.from(Department.class);


        criteriaQuery.select(criteriaBuilder.construct(ResponseSearchEquipmentDTO.class,
                equipmentRoot.get("id"),
                equipmentRoot.get("name"),
                equipmentTypeRoot.get("name"),
                employeeRoot.get("name"),
                livingRoomRoot.get("name"),
                departmentRoot.get("name")
                //equipmentRoot.get("brand")
        ));

        Predicate[] predicates = criarRestrincoes(search, criteriaBuilder, equipmentRoot, equipmentTypeRoot, employeeRoot, livingRoomRoot, departmentRoot);

        criteriaQuery.where(predicates);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

        private Predicate[] criarRestrincoes(SearchEquipmentDTO filter, CriteriaBuilder builder,  Root<Equipment> equipmentRoot, Root<EquipmentType> equipmentTypeRoot, Root<Employee> employeeRoot, Root<LivingRoom> livingRoomRoot, Root<Department> departmentRoot) {

            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(filter.getNameEquipment())) {
                predicates.add(builder.like(
                        builder.lower(equipmentRoot.get("name")),
                        "%" +  filter.getNameEquipment().trim().toLowerCase() + "%"));
                predicates.add(builder.equal(equipmentRoot.get("employee"), employeeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("equipmentType"), equipmentTypeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("livingRoom"), livingRoomRoot.get("id")));
                predicates.add(builder.equal(livingRoomRoot.get("department"), departmentRoot.get("id")));


            }

            if (!StringUtils.isEmpty(filter.getBrand())) {
                predicates.add(builder.like(
                        builder.lower(equipmentRoot.get("brand")),
                        "%" +  filter.getBrand().trim().toLowerCase() + "%"));
                predicates.add(builder.equal(equipmentRoot.get("employee"), employeeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("equipmentType"), equipmentTypeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("livingRoom"), livingRoomRoot.get("id")));
                predicates.add(builder.equal(livingRoomRoot.get("department"), departmentRoot.get("id")));


            }
            if (!StringUtils.isEmpty(filter.getEquipmentType())) {
                predicates.add(builder.like(
                        builder.lower(equipmentTypeRoot.get("name")),
                        "%" +  filter.getEquipmentType().trim().toLowerCase() + "%"));
                predicates.add(builder.equal(equipmentRoot.get("employee"), employeeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("equipmentType"), equipmentTypeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("livingRoom"), livingRoomRoot.get("id")));
                predicates.add(builder.equal(livingRoomRoot.get("department"), departmentRoot.get("id")));


            }

            if (!StringUtils.isEmpty(filter.getRoom())) {
                predicates.add(builder.like(
                        builder.lower(livingRoomRoot.get("name")),
                        "%" +  filter.getRoom().trim().toLowerCase() + "%"));
                predicates.add(builder.equal(equipmentRoot.get("employee"), employeeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("equipmentType"), equipmentTypeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("livingRoom"), livingRoomRoot.get("id")));
                predicates.add(builder.equal(livingRoomRoot.get("department"), departmentRoot.get("id")));


            }
            if (!StringUtils.isEmpty(filter.getDepartment())) {
                predicates.add(builder.like(
                        builder.lower(departmentRoot.get("name")),
                        "%" +  filter.getDepartment().trim().toLowerCase() + "%"));
                predicates.add(builder.equal(equipmentRoot.get("employee"), employeeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("equipmentType"), equipmentTypeRoot.get("id")));
                predicates.add(builder.equal(equipmentRoot.get("livingRoom"), livingRoomRoot.get("id")));
                predicates.add(builder.equal(livingRoomRoot.get("department"), departmentRoot.get("id")));


            }



            return predicates.toArray(new Predicate[predicates.size()]);
        }



}
