package escolaSpring.repositories;


import escolaSpring.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<escolaSpring.entities.Aluno, Long> {
    Optional<Aluno> findByMatricula(String matricula);
}
