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


}
