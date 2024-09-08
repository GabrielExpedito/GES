package escolavr.GES.Controller;

import escolavr.GES.Service.ProdutoService;
import escolavr.GES.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getProduto() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getProduto());
    }

    @PostMapping
    public ResponseEntity<String> inserirProduto(@RequestBody Produto produto) {
        try {
            produtoService.inserirProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Produto inserido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro a inserir o cliente");
        }
    }

    public ResponseEntity<String> deletarProduto(Integer id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar o Produto");

        }

    }

}
