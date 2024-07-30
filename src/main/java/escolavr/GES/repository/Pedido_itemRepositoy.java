package escolavr.GES.repository;

import escolavr.GES.entity.Pedido_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pedido_itemRepositoy extends JpaRepository<Pedido_item, Integer> {

}
