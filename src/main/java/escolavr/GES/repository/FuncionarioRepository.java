package escolavr.GES.repository;

import escolavr.GES.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.cargo = :cargo")
    Funcionario findFuncionarioByNomeAndCargo (@Param("nome") String nome,
                                               @Param("cargo") String cargo);


}
