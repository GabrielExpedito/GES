package escolavr.GES.Service;

import escolavr.GES.entity.Endereco;
import escolavr.GES.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> obterEndereco() {
        return enderecoRepository.findAll();
    }

    public Endereco obterEnderecoById(Integer Id) {
        Optional<Endereco> endereco = enderecoRepository.findById(Id);
        if (endereco.isEmpty()) {
            throw new RuntimeException("Não encontrado");
        }
        return endereco.get();
    }

    public Endereco inseriEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> acharEnderecoByDetalhes(Endereco endereco) {
        return enderecoRepository.acharRuaECidadeEEstadoECep0(endereco.getCep(), endereco.getRua(), endereco.getNr(),
                endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }

    public void deletarEndereco(Integer id) {
        enderecoRepository.deleteById(id);

    }


}
