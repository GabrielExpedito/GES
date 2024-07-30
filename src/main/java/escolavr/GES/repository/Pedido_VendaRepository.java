package escolavr.GES.repository;

import escolavr.GES.entity.Pedido_Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pedido_VendaRepository extends JpaRepository<Pedido_Venda, Integer> {
}
