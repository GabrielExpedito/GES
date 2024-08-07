package escolavr.GES.repository;

import escolavr.GES.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Optional<Endereco> acharRuaECidadeEEstadoECep0(String rua, String cidade, String estado, Integer cep);
}
