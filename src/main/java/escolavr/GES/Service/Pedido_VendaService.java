package escolavr.GES.Service;

import escolavr.GES.DTO.CriarPedidoItemDTO;
import escolavr.GES.DTO.CriarPedidoVendaDTO;
import escolavr.GES.entity.Pedido_Venda;
import escolavr.GES.entity.Pedido_item;
import escolavr.GES.repository.Pedido_VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido_VendaService {

    @Autowired
    Pedido_VendaRepository pedidoVendaRepository;

    public List<Pedido_Venda> getPedido() {
        return pedidoVendaRepository.findAll();
    }

    public Pedido_Venda inserirPedido(CriarPedidoVendaDTO criarPedidoVendaDTO) {
        Pedido_Venda pedidoVenda = new Pedido_Venda(null, criarPedidoVendaDTO.ID_Cliente(),
                criarPedidoVendaDTO.status(), criarPedidoVendaDTO.valor_total(), new Date(), new ArrayList<>());

        List<Pedido_item> itens = new ArrayList<>();

        for (CriarPedidoItemDTO item : criarPedidoVendaDTO.itens()) {
            itens.add(
                    new Pedido_item(item.quantidade(), item.valor_total(), item.ID_produto())
            );
        }
        pedidoVenda.setItens(itens);
        return pedidoVendaRepository.save(pedidoVenda);
    }

}
