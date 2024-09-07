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

    public void inserirFuncionario(Funcionario funcionario) throws Exception {
        Funcionario funcionarioExistente = getFuncionarioIfExists(funcionario);
        if (funcionarioExistente == null) {
            funcionarioRepository.save(funcionario);
        } else {
            throw new Exception("Funcionário já existente");
        }
    }


    private Funcionario getFuncionarioIfExists(Funcionario funcionario) {
        return acharFuncionarioByDetales(funcionario.getNome(), funcionario.getCargo());
    }

    private Funcionario acharFuncionarioByDetales(String nome, String cargo) {
        return funcionarioRepository.findFuncionarioByNomeAndCargo(nome, cargo);
    }

    public void deleteFuncionario(Integer NRE) {
        funcionarioRepository.deleteById(NRE);
    }


}
