package escolavr.GES.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", unique = true)
    private Integer id_endereco;

    private Integer cep;

    private String rua;

    private Integer nr;

    private String bairro;

    private String cidade;

    private String estado;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
