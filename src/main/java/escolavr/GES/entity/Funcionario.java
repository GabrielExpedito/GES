package escolavr.GES.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements Serializable {

    @Id
    @Column(name = "NRE", unique = true)
    private Integer NRE;
    private String nome;
    private String cargo;
    private Integer porce_comissao;

}
