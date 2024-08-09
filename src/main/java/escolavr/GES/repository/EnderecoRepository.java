package escolavr.GES.repository;

import escolavr.GES.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT e FROM Endereco e WHERE e.rua = :rua AND e.cidade = :cidade AND e.estado = :estado AND e.cep = :cep")
    Endereco findEnderecoByRuaAndCidadeAndEstadoAndCep(@Param("rua") String rua,
                                                                 @Param("cidade") String cidade,
                                                                 @Param("estado") String estado,
                                                                 @Param("cep") Integer cep);
}
