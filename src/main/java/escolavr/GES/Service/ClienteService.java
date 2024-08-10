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
        if (cliente.isEmpty()) {
            throw new RuntimeException("Não encontrado");
        }
        return cliente.get();
    }

    public void deletarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    public void inserirCliente(ClienteComEnderecoDto clienteComEnderecoDto) {
        Endereco endereco = getEnderecoIfExists(clienteComEnderecoDto);
        enderecoService.inseriEndereco(endereco);
        Cliente cliente = getClienteIfExits(clienteComEnderecoDto);
        clienteRepository.save(cliente);
    }

    private Endereco getEnderecoIfExists(ClienteComEnderecoDto clienteComEnderecoDto) {
        Endereco existirEndereco = enderecoService.acharEnderecoByDetalhes(clienteComEnderecoDto.cep(), clienteComEnderecoDto.rua(),
                clienteComEnderecoDto.nr(), clienteComEnderecoDto.bairro(), clienteComEnderecoDto.cidade(), clienteComEnderecoDto.estado());

        if (existirEndereco != null) {
            return existirEndereco;
        } else {
            Endereco endereco = new Endereco();
            endereco.setCep(clienteComEnderecoDto.cep());
            endereco.setRua(clienteComEnderecoDto.rua());
            endereco.setNr(clienteComEnderecoDto.nr());
            endereco.setBairro(clienteComEnderecoDto.bairro());
            endereco.setCidade(clienteComEnderecoDto.cidade());
            endereco.setEstado(clienteComEnderecoDto.estado());
            return endereco;
        }
    }

    private Cliente acharClienteByDetalhes(String nome, Integer idade, String telefone, String CPF) {
        return clienteRepository.findClientByNomeAndIdadeAndTelefoneAndCPF(nome, idade, telefone, CPF);
    }

    private Cliente getClienteIfExits(ClienteComEnderecoDto clienteComEnderecoDto) {
        Cliente existirCliente = acharClienteByDetalhes(clienteComEnderecoDto.nome(), clienteComEnderecoDto.idade(),
                clienteComEnderecoDto.telefone(), clienteComEnderecoDto.CPF());

        if (existirCliente != null) {
            return existirCliente;
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(clienteComEnderecoDto.nome());
            cliente.setIdade(clienteComEnderecoDto.idade());
            cliente.setTelefone(clienteComEnderecoDto.telefone());
            cliente.setCPF(clienteComEnderecoDto.CPF());
            return cliente;
        }
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

}
