package escolavr.GES.repository;

import escolavr.GES.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome AND p.preco = :preco AND p.categoria = :categoria")
    Produto findProdutoByNomeAndPrecoAndCategoria(@Param("nome") String nome,
                                                  @Param("preco") Double preco,
                                                  @Param("categoria") String categoria);

}
