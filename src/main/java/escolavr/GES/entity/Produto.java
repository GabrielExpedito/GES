package escolavr.GES.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_produto", unique = true)
    private Integer ID_produto;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;


}
