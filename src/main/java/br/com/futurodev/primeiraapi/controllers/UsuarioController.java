package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.dto.TelefoneRepresentationModel;
import br.com.futurodev.primeiraapi.dto.UsuarioRepresentationModel;
import br.com.futurodev.primeiraapi.input.UsuarioInput;
import br.com.futurodev.primeiraapi.model.Telefone;
import br.com.futurodev.primeiraapi.model.Usuario;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@Api(tags = "Usuários")
@ApiOperation(value="Fulano", nickname = "Gerenciador")
@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;


    @PostMapping(value="/",produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> cadastrar(@RequestBody UsuarioInput usuarioInput){

        Usuario usu = cadastroUsuarioService.salvar(toDomainObject(usuarioInput));
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu),HttpStatus.CREATED);
    }

    @PutMapping(value="/",produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> atualizar(@RequestBody UsuarioInput usuarioInput){
            Usuario usu = cadastroUsuarioService.salvar(toDomainObject(usuarioInput));

            return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu),HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUsuario){
        cadastroUsuarioService.delete(idUsuario);
        return new ResponseEntity<String>("DELETADO COM SUCESSO, O USUARIO",HttpStatus.OK);
    }

        @GetMapping(value="/{idUsuario}",produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> getUserById(@PathVariable(value="idUsuario") Long idUsuario){
        Usuario usu = cadastroUsuarioService.getUserById(idUsuario);
            UsuarioRepresentationModel usuarioRepresentationModel = toModel(usu);

            return new ResponseEntity<UsuarioRepresentationModel>(usuarioRepresentationModel,HttpStatus.OK);
        }




    @GetMapping(value="/buscarPorNome",produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UsuarioRepresentationModel>> getUserByName(@RequestParam (name="nome") String nome){
        List<Usuario> usuarios = cadastroUsuarioService.getUserByName(nome);
        List<UsuarioRepresentationModel> usuariosRepresentationModel = toCollectionModel(usuarios);
        return new ResponseEntity<List<UsuarioRepresentationModel>>(usuariosRepresentationModel,HttpStatus.OK);
    }

    private UsuarioRepresentationModel toModel(Usuario usu) {
        UsuarioRepresentationModel usuarioRepresentationModel = new UsuarioRepresentationModel();
        usuarioRepresentationModel.setId(usu.getId());
        usuarioRepresentationModel.setNome(usu.getNome());
        usuarioRepresentationModel.setLogin(usu.getLogin());
        usuarioRepresentationModel.setDataCadastro(usu.getDataCadastro());
        usuarioRepresentationModel.setDataAtualizacao(usu.getDataAtualizacao());
//       List< TelefoneRepresentationModel> telefonesRepresentationModel = new ArrayList<TelefoneRepresentationModel>();
        for(int i =0;i<usu.getTelefones().size();++i){
            TelefoneRepresentationModel telefoneRepresentationModel = new TelefoneRepresentationModel();
            telefoneRepresentationModel.setTipo(usu.getTelefones().get(i).getTipo());
            telefoneRepresentationModel.setNumero(usu.getTelefones().get(i).getNumero());
            telefoneRepresentationModel.setId(usu.getTelefones().get(i).getIdUsuario());
//            usuarioRepresentationModel.setTelefones(telefonesRepresentationModel);
            usuarioRepresentationModel.getTelefones().add(telefoneRepresentationModel);

        }

        return usuarioRepresentationModel;
    }

    public List<UsuarioRepresentationModel> toCollectionModel(List<Usuario> usuariosModel){
        return usuariosModel.stream().map(usuarioModel->toModel(usuarioModel)).collect(Collectors.toList());
    }

    private Usuario toDomainObject(UsuarioInput usuarioInput){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioInput.getId());
        usuario.setNome(usuarioInput.getNome());
        usuario.setLogin(usuarioInput.getLogin());
        usuario.setSenha(usuarioInput.getSenha());

        for(int i =0;i<usuarioInput.getTelefones().size();++i){
            Telefone telefone = new Telefone();
            telefone.setTipo(usuarioInput.getTelefones().get(i).getTipo());
            telefone.setNumero(usuarioInput.getTelefones().get(i).getNumero());
            telefone.setId(usuarioInput.getTelefones().get(i).getId());
//            usuarioRepresentationModel.setTelefones(telefonesRepresentationModel);
            usuario.getTelefones().add(telefone);

        }

        return usuario;
    }

}
