package br.com.futurodev.primeiraapi.controllers;


import br.com.futurodev.primeiraapi.model.PedidoModel;
import br.com.futurodev.primeiraapi.model.Produto;
import br.com.futurodev.primeiraapi.service.PedidoService;
import br.com.futurodev.primeiraapi.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Produtos")
@ApiOperation(value="Produto X", nickname = "Gerenciador")
@RestController
@RequestMapping(value="/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value="/",produces = "application/json")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto prod){
        Produto ped = produtoService.salvar(prod);
        return new ResponseEntity<Produto>(ped, HttpStatus.CREATED);

    }

    @PutMapping(value="/",produces = "application/json")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto prod){
        Produto ped = produtoService.salvar(prod);
        return new ResponseEntity<Produto>(ped, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduto){
        produtoService.delete(idProduto);
        return new ResponseEntity<String>("DELETADO COM SUCESSO, O PRODUTO",HttpStatus.OK);
    }
}
