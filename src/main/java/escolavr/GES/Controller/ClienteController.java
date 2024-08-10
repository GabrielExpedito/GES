package escolavr.GES.Controller;

import ch.qos.logback.core.net.server.Client;
import escolavr.GES.DTO.ClienteComEnderecoDto;
import escolavr.GES.Service.ClienteService;
import escolavr.GES.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.obterClientes());
    }

    @PostMapping
    public ResponseEntity<String> inserirCliente(@RequestBody ClienteComEnderecoDto clienteComEnderecoDto) {
        try {
            clienteService.inserirCliente(clienteComEnderecoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente inserido com sucesso");
        }catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao inserir Cliente");
        }
    }

}
