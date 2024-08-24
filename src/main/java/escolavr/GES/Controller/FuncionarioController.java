package escolavr.GES.Controller;

import escolavr.GES.Service.FuncionarioService;
import escolavr.GES.entity.Cliente;
import escolavr.GES.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Funcionario")
public class FuncionarioController {


    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionario() {
            return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getFuncionario());
    }






}
