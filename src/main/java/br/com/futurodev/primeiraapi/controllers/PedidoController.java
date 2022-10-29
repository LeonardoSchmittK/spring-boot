package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.dto.UsuarioRepresentationModel;
import br.com.futurodev.primeiraapi.input.UsuarioInput;
import br.com.futurodev.primeiraapi.model.PedidoModel;
import br.com.futurodev.primeiraapi.model.Usuario;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import br.com.futurodev.primeiraapi.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Pedidos")
@ApiOperation(value="Pedido X")
@RestController
@RequestMapping(value="/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value="/",produces = "application/json")
    public ResponseEntity<PedidoModel> cadastrar(@RequestBody PedidoModel pedido){
        PedidoModel ped = pedidoService.salvar(pedido);
        return new ResponseEntity<PedidoModel>(ped, HttpStatus.CREATED);

    }

    @PutMapping(value="/",produces = "application/json")
    public ResponseEntity<PedidoModel> atualizar(@RequestBody PedidoModel pedido){
        PedidoModel ped = pedidoService.salvar(pedido);
        return new ResponseEntity<PedidoModel>(ped, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPedido){
        pedidoService.delete(idPedido);
        return new ResponseEntity<String>("DELETADO COM SUCESSO, O PEDIDO",HttpStatus.OK);
    }

}
