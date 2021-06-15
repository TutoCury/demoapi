package br.com.tuto.demoapi.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoRest
{

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getProdutos()
    {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable("id") Long id)
    {
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto)
    {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable("id") Long id, @RequestBody Produto produto)
    {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public Produto deleteProduto(@PathVariable("id") Long id)
    {
        Produto produto = produtoRepository.findById(id).orElse(null);
        produtoRepository.deleteById(id);
        return produto;
    }

}
