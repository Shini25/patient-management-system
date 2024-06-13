package leopard.PatientManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import leopard.PatientManagement.model.Consultation;
import leopard.PatientManagement.service.ConsultationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;

    @Autowired
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        List<Consultation> consultations = consultationService.getAllConsultations();
        return ResponseEntity.ok(consultations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable Long id) {
        Optional<Consultation> consultation = consultationService.getConsultationById(id);
        return consultation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addConsultation")
    public ResponseEntity<Consultation> addConsultation(@RequestBody Consultation consultation) {
        Consultation savedConsultation = consultationService.saveConsultation(consultation);
        return new ResponseEntity<>(savedConsultation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        if (!consultationService.getConsultationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        consultation.setId(id);
        Consultation updatedConsultation = consultationService.saveConsultation(consultation);
        return ResponseEntity.ok(updatedConsultation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long id) {
        if (!consultationService.getConsultationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        consultationService.deleteConsultation(id);
        return ResponseEntity.noContent().build();
    }
}