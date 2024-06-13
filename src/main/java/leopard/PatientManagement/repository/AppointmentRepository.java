package leopard.PatientManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import leopard.PatientManagement.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // You can add custom query methods here if needed
}
