package escolaSpring.repositories;

import escolaSpring.entities.Aluno;
import escolaSpring.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
