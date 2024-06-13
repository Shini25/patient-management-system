package leopard.PatientManagement.service;

import leopard.PatientManagement.model.Patient;
import leopard.PatientManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll(Sort.by(Sort.Direction.DESC, "id")); // Remplacez 'id' par le champ approprié, comme 'createdAt' si disponible
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }


    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient); // Implémentez la logique de mise à jour ici
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
