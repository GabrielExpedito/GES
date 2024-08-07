package escolavr.GES.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    private String nome;

    private Integer idade;

    private String telefone;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    private String CPF;


}
