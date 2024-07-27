package escolavr.GES.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    private Integer NRE;
    private String nome;
    private String carro;
    private Integer porce_comissao;

}
