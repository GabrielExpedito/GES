package escolavr.GES.Controller;

import escolavr.GES.Service.EnderecoService;
import escolavr.GES.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/Endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getEndereco() {
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoService.obterEndereco());
     }

    @PostMapping
    public ResponseEntity<String> inserirEndereco(@RequestBody Endereco endereco) {
        enderecoService.inseriEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço inserido com sucesso");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable(value = "id") Integer id) {
        try {
            enderecoService.deletarEndereco(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereco deletado com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao deletar o endereco");
        }
    }





}
