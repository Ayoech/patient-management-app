package medecin.example.patient.repositories;

import medecin.example.patient.entities.Medecin;
import medecin.example.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
