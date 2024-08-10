package escolavr.GES.repository;

import escolavr.GES.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT * FROM Cliente c WHERE c.nome = :nome AND c.idade = :idade AND c.telefone = :telefone AND c.CPF = :CPF")
    Cliente findClientByNomeAndIdadeAndTelefoneAndCPF(@Param("nome") String nome,
                                                      @Param("idade") Integer idade,
                                                      @Param("telefone") String telefone,
                                                      @Param("CPF") String CPF);
}
