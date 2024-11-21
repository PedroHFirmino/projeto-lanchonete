package pedro.firmino.lanches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedro.firmino.lanches.model.cliente;
import pedro.firmino.lanches.repository.clienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {

    @Autowired
    private clienteRepository repository;

    @GetMapping
    public List<cliente> findAll() {
        return this.repository.findAll();
    };

    @GetMapping("/{id}")
    public cliente findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

}
