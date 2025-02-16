package esprit.tn.examenrdv.services;

import esprit.tn.examenrdv.entities.RendezVous;
import esprit.tn.examenrdv.repositories.RendezVousRepository;
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
class RendezVousServiceTest {

    @Mock
    private RendezVousRepository rendezVousRepository;

    @InjectMocks
    private RendezVousService rendezVousService;

    private RendezVous rendezVous;

    @BeforeEach
    void setUp() {
        rendezVous = new RendezVous();
        rendezVous.setIdRDV(1L);
    }

    @Test
    void testSaveRendezVous() {
        when(rendezVousRepository.save(rendezVous)).thenReturn(rendezVous);
        RendezVous savedRendezVous = rendezVousService.saveRendezVous(rendezVous);
        assertNotNull(savedRendezVous);
    }

    @Test
    void testGetAllRendezVous() {
        when(rendezVousRepository.findAll()).thenReturn(Arrays.asList(rendezVous));
        List<RendezVous> rendezVousList = rendezVousService.getAllRendezVous();
        assertFalse(rendezVousList.isEmpty());
    }

    @Test
    void testGetRendezVousById() {
        when(rendezVousRepository.findById(1L)).thenReturn(Optional.of(rendezVous));
        Optional<RendezVous> found = rendezVousService.getRendezVousById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testDeleteRendezVous() {
        doNothing().when(rendezVousRepository).deleteById(1L);
        rendezVousService.deleteRendezVous(1L);
        verify(rendezVousRepository, times(1)).deleteById(1L);
    }
}
