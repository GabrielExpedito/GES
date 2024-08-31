package escolavr.GES.Service;

import escolavr.GES.entity.Produto;
import escolavr.GES.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getProduto() {
        return produtoRepository.findAll();
    }

    public void inserirProduto(Produto produto) throws Exception {
        Produto produtoExistente = getProdutoIfExists(produto);
        if (produtoExistente == null) {
            produtoRepository.save(produto);
        } else {
            throw new Exception("Produto já exitente");
        }
    }


    private Produto getProdutoIfExists(Produto produto) {
        return acharProdutoByDetalhes(produto.getNome(), produto.getPreco(), produto.getCategoria());
    }

    private Produto acharProdutoByDetalhes(String nome, Double preco, String categoria) {
        return produtoRepository.findProdutoByNomeAndPrecoAndCategoria(nome, preco, categoria);
    }

}
