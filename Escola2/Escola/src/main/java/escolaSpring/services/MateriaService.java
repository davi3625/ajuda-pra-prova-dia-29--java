package escolaSpring.services;

import escolaSpring.entities.Materia;
import escolaSpring.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository repo;

    public List<Materia> listar() {
        return repo.findAll();
    }

    public Materia buscarPorId(Long id) {
        Optional<Materia> mat = repo.findById(id);
        return mat.orElse(null);
    }

    public Materia salvar(Materia materia) {
        return repo.save(materia);
    }

    public Materia atualizar(Long id, Materia nova) {
        Materia existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(nova.getNome());
            existente.setCargaHoraria(nova.getCargaHoraria());
            existente.setProfessor(nova.getProfessor());
            return repo.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
