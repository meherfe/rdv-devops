package esprit.tn.examenrdv.services;

import esprit.tn.examenrdv.entities.Patient;
import esprit.tn.examenrdv.repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setIdPatient(1L);
        patient.setNomPatient("John Doe");
    }

    @Test
    void testSavePatient() {
        when(patientRepository.save(patient)).thenReturn(patient);
        Patient savedPatient = patientService.savePatient(patient);
        assertNotNull(savedPatient);
    }

    @Test
    void testGetAllPatients() {
        when(patientRepository.findAll()).thenReturn(Arrays.asList(patient));
        List<Patient> patients = patientService.getAllPatients();
        assertFalse(patients.isEmpty());
    }

    @Test
    void testGetPatientById() {
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
        Optional<Patient> found = patientService.getPatientById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testDeletePatient() {
        doNothing().when(patientRepository).deleteById(1L);
        patientService.deletePatient(1L);
        verify(patientRepository, times(1)).deleteById(1L);
    }
}
