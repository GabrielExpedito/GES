package escolavr.GES.DTO;

import java.util.List;

public record CriarPedidoVendaDTO(
        Integer ID_Cliente,
        String status,
        Double valor_total,

        List<CriarPedidoItemDTO> itens


) {


}
