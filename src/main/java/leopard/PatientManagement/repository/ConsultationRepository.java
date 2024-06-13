package leopard.PatientManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import leopard.PatientManagement.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    // You can add custom query methods here if needed
}