package escolaSpring.services;

import escolaSpring.entities.Aluno;
import escolaSpring.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repo;

    public List<Aluno> listar() {
        return repo.findAll();
    }

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> aluno = repo.findById(id);
        return aluno.orElse(null);
    }

    public Aluno salvar(Aluno aluno) {
        return repo.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno novo) {
        Aluno existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(novo.getNome());
            existente.setCpf(novo.getCpf());
            existente.setDataDeNascimento(novo.getDataDeNascimento());
            existente.setMatricula(novo.getMatricula());
            return repo.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
