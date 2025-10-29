package escolaSpring.controllers;

import escolaSpring.entities.Nota;
import escolaSpring.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService service;

    @GetMapping
    public List<Nota> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Nota buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Nota criar(@RequestBody Nota nota) {
        return service.salvar(nota);
    }

    @PutMapping("/{id}")
    public Nota atualizar(@PathVariable Long id, @RequestBody Nota nota) {
        return service.atualizar(id, nota);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
