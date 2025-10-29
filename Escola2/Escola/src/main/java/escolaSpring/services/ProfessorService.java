package escolaSpring.services;

import escolaSpring.entities.Professor;
import escolaSpring.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repo;

    public List<Professor> listar() {
        return repo.findAll();
    }

    public Professor buscarPorId(Long id) {
        Optional<Professor> prof = repo.findById(id);
        return prof.orElse(null);
    }

    public Professor salvar(Professor professor) {
        return repo.save(professor);
    }

    public Professor atualizar(Long id, Professor novo) {
        Professor existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(novo.getNome());
            existente.setCpf(novo.getCpf());
            existente.setDataDeNascimento(novo.getDataDeNascimento());
            existente.setEmail(novo.getEmail());
            return repo.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
