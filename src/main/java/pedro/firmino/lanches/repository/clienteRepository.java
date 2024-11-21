package pedro.firmino.lanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.firmino.lanches.model.cliente;

public interface clienteRepository extends JpaRepository<cliente, Integer> {

}
