package ricardo.gabriel.praticando_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ricardo.gabriel.praticando_spring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui você pode definir métodos personalizados para acessar os dados dos produtos


}