package escolavr.GES.Controller;

import escolavr.GES.Service.FuncionarioService;
import escolavr.GES.entity.Cliente;
import escolavr.GES.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/Funcionario")
public class FuncionarioController {


    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionario() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getFuncionario());
    }

    @PostMapping
    public ResponseEntity<String> inserirFuncionario(@RequestBody Funcionario funcionario) {
        try {
            funcionarioService.inserirFuncionario(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario inserido com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFuncionario(Integer NRE) {
        try {
            funcionarioService.deleteFuncionario(NRE);
            return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar Funcionario");
        }
    }


}
