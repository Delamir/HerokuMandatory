package dk.kea.herokumandatory.repositories;

import dk.kea.herokumandatory.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
