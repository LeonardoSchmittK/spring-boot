package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.Repository.ProdutoRepository;
import br.com.futurodev.primeiraapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }



    @RequestMapping(value = "/produto/{descricao}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvar(@PathVariable String descricao){
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produtoRepository.save(produto);
        return "Produto " + descricao + " registrado com sucesso";
    }

    @GetMapping("/produtos")
    @ResponseBody
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
    }

    @PostMapping(value="/produto/salvar")
    @ResponseBody
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        Produto prod = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(prod,HttpStatus.CREATED);
    }


        @DeleteMapping(value="/produto/delete")
        @ResponseBody
        public ResponseEntity<String> delete(@RequestParam Long idProduto){
            produtoRepository.deleteById(idProduto);
            return new ResponseEntity<String>("Produto deletado com sucesso",HttpStatus.OK);
        }
}
