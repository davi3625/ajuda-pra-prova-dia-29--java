package escolaSpring.services;

import escolaSpring.entities.Nota;
import escolaSpring.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repo;

    public List<Nota> listar() {
        return repo.findAll();
    }

    public Nota buscarPorId(Long id) {
        Optional<Nota> nota = repo.findById(id);
        return nota.orElse(null);
    }

    public Nota salvar(Nota nota) {
        return repo.save(nota);
    }

    public Nota atualizar(Long id, Nota nova) {
        Nota existente = buscarPorId(id);
        if (existente != null) {
            existente.setValor(nova.getValor());
            existente.setAluno(nova.getAluno());
            existente.setMateria(nova.getMateria());
            return repo.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
