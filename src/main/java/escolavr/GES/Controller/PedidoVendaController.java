package escolavr.GES.Controller;

import escolavr.GES.DTO.CriarPedidoVendaDTO;
import escolavr.GES.Service.Pedido_VendaService;
import escolavr.GES.entity.Pedido_Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/PedidoVenda")
public class PedidoVendaController {

    @Autowired
    Pedido_VendaService pedidoVendaService;


    @GetMapping
    public ResponseEntity<List<Pedido_Venda>> getPedidoVenda() {
        return ResponseEntity.status(HttpStatus.FOUND).body(pedidoVendaService.getPedido());
    }

    @PostMapping
    public ResponseEntity<Pedido_Venda> cadastrarPedido(@RequestBody(required = false) CriarPedidoVendaDTO criarPedidoVendaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoVendaService.inserirPedido(criarPedidoVendaDTO));
    }





}
