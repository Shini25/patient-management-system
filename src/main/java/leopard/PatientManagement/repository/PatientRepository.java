package leopard.PatientManagement.repository;

import leopard.PatientManagement.model.Patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll(Sort sort);

}
