package escolavr.GES.Controller;

import escolavr.GES.Service.Pedido_VendaService;
import escolavr.GES.entity.Pedido_Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
