package escolavr.GES.repository;

import escolavr.GES.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT e FROM Endereco e WHERE e.cep = :cep AND e.rua = :rua AND e.nr = :nr AND " +
            "e.bairro = :bairro AND e.cidade = :cidade AND e.estado = :estado")
    Endereco findEnderecoByRuaAndCidadeAndEstadoAndCep(@Param("cep") Integer cep,
                                                       @Param("rua") String rua,
                                                       @Param("nr") Integer nr,
                                                       @Param("bairro") String bairro,
                                                       @Param("cidade") String cidade,
                                                       @Param("estado") String estado);

}
