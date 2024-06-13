package leopard.PatientManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import leopard.PatientManagement.model.Consultation;
import leopard.PatientManagement.repository.ConsultationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}