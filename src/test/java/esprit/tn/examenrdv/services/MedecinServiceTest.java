package esprit.tn.examenrdv.services;

import esprit.tn.examenrdv.entities.Medecin;
import esprit.tn.examenrdv.repositories.MedecinRepository;
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
class MedecinServiceTest {

    @Mock
    private MedecinRepository medecinRepository;

    @InjectMocks
    private MedecinService medecinService;

    private Medecin medecin;

    @BeforeEach
    void setUp() {
        medecin = new Medecin();
        medecin.setIdMedecin(1L);
        medecin.setNomMedecin("Dr. Smith");
    }

    @Test
    void testSaveMedecin() {
        when(medecinRepository.save(medecin)).thenReturn(medecin);
        Medecin savedMedecin = medecinService.saveMedecin(medecin);
        assertNotNull(savedMedecin);
    }

    @Test
    void testGetAllMedecins() {
        when(medecinRepository.findAll()).thenReturn(Arrays.asList(medecin));
        List<Medecin> medecins = medecinService.getAllMedecins();
        assertFalse(medecins.isEmpty());
    }

    @Test
    void testGetMedecinById() {
        when(medecinRepository.findById(1L)).thenReturn(Optional.of(medecin));
        Optional<Medecin> found = medecinService.getMedecinById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testDeleteMedecin() {
        doNothing().when(medecinRepository).deleteById(1L);
        medecinService.deleteMedecin(1L);
        verify(medecinRepository, times(1)).deleteById(1L);
    }
}
