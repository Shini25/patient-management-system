package leopard.PatientManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import leopard.PatientManagement.enums.PatientGender;
import leopard.PatientManagement.enums.PatientCategory;

import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String address;

    private String email;

    private String phoneNumber;

    private PatientGender gender;

    private PatientCategory patientCategory;
    private boolean consultationStatus;
    private boolean appointmentStatus;

    // Constructor
    public Patient() {}

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, String phoneNumber, PatientGender gender, PatientCategory patientCategory, boolean consultationStatus, boolean appointmentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.patientCategory = patientCategory;
        this.consultationStatus = consultationStatus;
        this.appointmentStatus = appointmentStatus;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PatientGender getGender() {
        return gender;
    }

    public void setGender(PatientGender gender) {
        this.gender = gender;
    }

    public PatientCategory getPatientCategory() {
        return patientCategory;
    }

    public void setPatientCategory(PatientCategory patientCategory) {
        this.patientCategory = patientCategory;
    }

    public boolean isConsultationStatus() {
        return consultationStatus;
    }

    public void setConsultationStatus(boolean consultationStatus) {
        this.consultationStatus = consultationStatus;
    }

    public boolean isAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(boolean appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}