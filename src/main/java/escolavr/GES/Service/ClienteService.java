package escolavr.GES.Service;

import ch.qos.logback.core.net.server.Client;
import escolavr.GES.DTO.ClienteComEnderecoDto;
import escolavr.GES.entity.Cliente;
import escolavr.GES.entity.Endereco;
import escolavr.GES.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoService enderecoService;

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
        validarEnderecoEInserirCliente(cliente);
        //validar se cliente existe
        //inserir cliente e endereco
    }

    private void validarEnderecoEInserirCliente(ClienteComEnderecoDto clienteComEnderecoDto) {
        Endereco existirEndereco = enderecoService.acharEnderecoByDetalhes(clienteComEnderecoDto.ge, clienteComEnderecoDto.getCidade(), clienteComEnderecoDto.getEstado(), clienteComEnderecoDto.getCep());
        Cliente cliente = new Cliente();

        if(existirEndereco != null) {
            cliente.setEnderece(existirEndereco);
        } else {
            Endereco endereco = new Endereco();
            endereco.setRua(clienteComEnderecoDto.getRua());

            enderecoService.inseriEndereco(endereco);
            cliente.setEndereco(novoEndereco);
        }

        cliente.setNome(clienteComEnderecoDto.getNome());
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

}
