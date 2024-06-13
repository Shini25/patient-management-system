package leopard.PatientManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private  LocalDate  consultationDate;

    private String consultationReason;

    private String diagnosis;

    private String prescribedTreatment;

    private String testResults;

    private double consultationFee;

    private boolean paymentStatus;

    private String observations;

    // Constructors, getters, and setters

    public Consultation() {
    }

    public Consultation(Patient patient, Doctor doctor,  LocalDate consultationDate, String consultationReason, String diagnosis, String prescribedTreatment, String testResults, double consultationFee, boolean paymentStatus, String observations) {
        this.patient = patient;
        this.doctor = doctor;
        this.consultationDate = consultationDate;
        this.consultationReason = consultationReason;
        this.diagnosis = diagnosis;
        this.prescribedTreatment = prescribedTreatment;
        this.testResults = testResults;
        this.consultationFee = consultationFee;
        this.paymentStatus = paymentStatus;
        this.observations = observations;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public  LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate( LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescribedTreatment() {
        return prescribedTreatment;
    }

    public void setPrescribedTreatment(String prescribedTreatment) {
        this.prescribedTreatment = prescribedTreatment;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}