package escolavr.GES.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /*corrigir na tabela do banco de dados*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_pedido;

    @OneToMany(mappedBy = "pedidoVenda", cascade = CascadeType.ALL)
    private List<Pedido_item> itens = new ArrayList<>();
}
