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

    private Integer quantidade;

    private Double valor_total;

    @Column(name = "idProduto")
    private Integer idProduto;

    @OneToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "NR_Ped", nullable = false)
    private Pedido_Venda pedidoVenda;

    public Pedido_item(Integer quantidade, Double valor_total, Integer idProduto) {
        this.quantidade = quantidade;
        this.valor_total = valor_total;
        this.idProduto = idProduto;
    }
}
