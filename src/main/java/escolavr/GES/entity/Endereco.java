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

    private Integer CEP;
    private String rua;
    private Integer NR;
    private String bairro;
    private String cidade;
    private String estado;


}
