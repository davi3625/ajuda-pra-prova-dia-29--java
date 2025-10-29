package escolaSpring.services;

import escolaSpring.entities.Departamento;
import escolaSpring.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repo;

    public List<Departamento> listar() {
        return repo.findAll();
    }

    public Departamento buscarPorId(Long id) {
        Optional<Departamento> dep = repo.findById(id);
        return dep.orElse(null);
    }

    public Departamento salvar(Departamento departamento) {
        return repo.save(departamento);
    }

    public Departamento atualizar(Long id, Departamento novo) {
        Departamento existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(novo.getNome());
            return repo.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
