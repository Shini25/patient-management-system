package leopard.PatientManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import leopard.PatientManagement.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Vous pouvez ajouter des méthodes personnalisées de recherche si nécessaire
}