package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.model.FormaPagamentoModel;
import br.com.futurodev.primeiraapi.model.PedidoModel;
import br.com.futurodev.primeiraapi.model.Produto;
import br.com.futurodev.primeiraapi.service.FormaPagamentoService;
import br.com.futurodev.primeiraapi.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "FormaPagamento")
@ApiOperation(value="FormaPagamento X")
@RestController
@RequestMapping(value="/formaPagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping(value="/",produces = "application/json")
    public ResponseEntity<FormaPagamentoModel> cadastrar(@RequestBody FormaPagamentoModel formaPagamento){
       FormaPagamentoModel forma =  FormaPagamentoService.salvar(formaPagamento);
        return new ResponseEntity<FormaPagamentoModel>(forma, HttpStatus.CREATED);
    }

    @PutMapping(value="/",produces = "application/json")
    public ResponseEntity<FormaPagamentoModel> atualizar(@RequestBody FormaPagamentoModel forma){
        FormaPagamentoModel ped = formaPagamentoService.salvar(forma);
        return new ResponseEntity<FormaPagamentoModel>(ped, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idFormaPagamento){
        formaPagamentoService.delete(idFormaPagamento);
        return new ResponseEntity<String>("DELETADO COM SUCESSO, A FORMA DE PAGAMENTO",HttpStatus.OK);
    }

}