package ricardo.gabriel.praticando_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ricardo.gabriel.praticando_spring.exceptions.RecursoNaoEncontradoException;
import ricardo.gabriel.praticando_spring.model.Produto;
import ricardo.gabriel.praticando_spring.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Produto " + id + " não encontrado"));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) { 
            throw new RecursoNaoEncontradoException("Produto " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
