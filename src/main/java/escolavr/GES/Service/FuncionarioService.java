package escolavr.GES.Service;

import escolavr.GES.entity.Funcionario;
import escolavr.GES.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;


    public List<Funcionario> getFuncionario() {
        return funcionarioRepository.findAll();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }


}
