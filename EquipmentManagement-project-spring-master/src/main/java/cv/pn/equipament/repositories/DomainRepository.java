package cv.pn.equipament.repositories;

import cv.pn.equipament.models.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomainRepository extends JpaRepository<Domain, String> {
    Optional<Domain> findByCode(String Code);
    List<Domain> findBySelfId(String SelfId);



}
