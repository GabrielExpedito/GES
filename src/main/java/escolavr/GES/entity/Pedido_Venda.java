package escolavr.GES.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido_Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_Ped", unique = true)
    private Integer NR_Ped;
    private Integer ID_Cliente;
    private String status;
    private Double valor_total;
    private Integer ID_pedido_item;

}
