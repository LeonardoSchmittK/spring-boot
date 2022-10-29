package br.com.futurodev.primeiraapi.service;

import br.com.futurodev.primeiraapi.Repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CadastroUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public Usuario getUserById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    public List<Usuario> getUserByName(@RequestParam(name="nome") String nome){
        return usuarioRepository.getUsuarioByName(nome);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUserByLogin(username);
        if(usuario==null){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
        return new User(usuario.getLogin(),usuario.getPassword(),usuario.getAuthorities());
    }
}
