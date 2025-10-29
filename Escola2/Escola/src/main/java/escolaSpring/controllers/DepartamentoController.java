package escolaSpring.controllers;

import escolaSpring.entities.Departamento;
import escolaSpring.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public List<Departamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Departamento buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Departamento criar(@RequestBody Departamento departamento) {
        return service.salvar(departamento);
    }

    @PutMapping("/{id}")
    public Departamento atualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
        return service.atualizar(id, departamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
