package pedro.firmino.lanches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.web.bind.annotation.*;
import pedro.firmino.lanches.dto.clienteRequestDto;
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

    @PostMapping
    public cliente save(@RequestBody clienteRequestDto dto) {
        cliente cliente = new cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        return this.repository.save(cliente);
    }

    @PutMapping("/{id}")
    public cliente update(@PathVariable Integer id,
                          @RequestBody clienteRequestDto dto) {
        cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        return this.repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        this.repository.delete(cliente);

    }

}
