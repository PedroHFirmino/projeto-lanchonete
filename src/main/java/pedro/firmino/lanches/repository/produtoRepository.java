package pedro.firmino.lanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.firmino.lanches.model.produto;

public interface produtoRepository extends JpaRepository<produto, Integer> {
}
