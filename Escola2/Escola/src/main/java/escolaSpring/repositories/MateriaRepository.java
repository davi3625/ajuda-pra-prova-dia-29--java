package escolaSpring.repositories;

import escolaSpring.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MateriaRepository extends JpaRepository<Materia, Long> {}
