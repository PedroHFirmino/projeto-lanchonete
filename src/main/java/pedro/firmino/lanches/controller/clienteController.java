package pedro.firmino.lanches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pedro.firmino.lanches.model.cliente;
import pedro.firmino.lanches.repository.clienteRepository;

import java.util.List;

@RestController
public class clienteController {

    @Autowired
    private clienteRepository repository;

    @GetMapping("/clientes")
    public List<cliente> findAll() {
        return this.repository.findAll();
    };


}
