package esprit.tn.examenrdv.services;

import esprit.tn.examenrdv.entities.Clinique;
import esprit.tn.examenrdv.repositories.CliniqueRepository;
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
class CliniqueServiceTest {

    @Mock
    private CliniqueRepository cliniqueRepository;

    @InjectMocks
    private CliniqueService cliniqueService;

    private Clinique clinique;

    @BeforeEach
    void setUp() {
        clinique = new Clinique();
        clinique.setIdClinique(1L);
        clinique.setNomClinique("Clinique El Amen");
    }

    @Test
    void testSaveClinique() {
        when(cliniqueRepository.save(clinique)).thenReturn(clinique);
        Clinique savedClinique = cliniqueService.saveClinique(clinique);
        assertNotNull(savedClinique);
        assertEquals("Clinique El Amen", savedClinique.getNomClinique());
    }

    @Test
    void testGetAllCliniques() {
        when(cliniqueRepository.findAll()).thenReturn(Arrays.asList(clinique));
        List<Clinique> cliniques = cliniqueService.getAllCliniques();
        assertFalse(cliniques.isEmpty());
    }

    @Test
    void testGetCliniqueById() {
        when(cliniqueRepository.findById(1L)).thenReturn(Optional.of(clinique));
        Optional<Clinique> found = cliniqueService.getCliniqueById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testDeleteClinique() {
        doNothing().when(cliniqueRepository).deleteById(1L);
        cliniqueService.deleteClinique(1L);
        verify(cliniqueRepository, times(1)).deleteById(1L);
    }
}
