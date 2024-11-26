package pedro.firmino.lanches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.firmino.lanches.dto.produtoRequestDto;
import pedro.firmino.lanches.repository.produtoRepository;
import pedro.firmino.lanches.model.produto;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class produtoController {

    @Autowired
    private produtoRepository repository;

    @GetMapping
    public ResponseEntity<List<produto>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<produto> findById(@PathVariable Integer id) {
        produto produto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public produto save(@RequestBody produtoRequestDto dto) {
        produto produto = new produto();
        produto.setNome(dto.nome());
        produto.setPreco(BigDecimal.valueOf(dto.preco()));
        produto.setDescricao(dto.descricao());

        return this.repository.save(produto);
    }

    @PutMapping("/{id}")
    public produto update(@PathVariable Integer id,
                          @RequestBody produtoRequestDto dto) {
        produto produto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produto.setNome(dto.nome());
        produto.setPreco(BigDecimal.valueOf(dto.preco()));
        produto.setDescricao(dto.descricao());

        return this.repository.save(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produto produto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }
}
