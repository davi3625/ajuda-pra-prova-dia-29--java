package escolaSpring.controllers;

import escolaSpring.entities.Materia;
import escolaSpring.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @GetMapping
    public List<Materia> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Materia buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Materia criar(@RequestBody Materia materia) {
        return service.salvar(materia);
    }

    @PutMapping("/{id}")
    public Materia atualizar(@PathVariable Long id, @RequestBody Materia materia) {
        return service.atualizar(id, materia);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
