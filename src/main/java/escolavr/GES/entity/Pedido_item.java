package escolavr.GES.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_pedido_item", unique = true)
    private Integer ID_pedido_item;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_pedido;

    private Integer quantidade;

    private Double valor_total;

    private Integer ID_produto;

}
