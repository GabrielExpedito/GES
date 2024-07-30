package escolavr.GES.Service;

import escolavr.GES.entity.Cliente;
import escolavr.GES.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> obterClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obterClienteByID(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()) {
            throw new RuntimeException("Não encontrado");
        }
        return cliente.get();
    }

    public void deletarCliente(Integer id) {
       clienteRepository.deleteById(id);
    }

    public void inserirCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

}
