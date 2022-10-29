package br.com.futurodev.primeiraapi.service;

import br.com.futurodev.primeiraapi.Repository.PedidoRepository;
import br.com.futurodev.primeiraapi.Repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.model.PedidoModel;
import br.com.futurodev.primeiraapi.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PedidoService implements UserDetailsService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel salvar(PedidoModel pedido){
        return pedidoRepository.save(pedido);
    }

    public void delete(Long idUsuario){
        pedidoRepository.deleteById(idUsuario);
    }

    public PedidoModel getPedidoById(@RequestParam Long id){
        return pedidoRepository.getPedidoModelById(id);
    }

//    public List<PedidoModel> getPedidoByClientName(@RequestParam (name="nome") String nome){
//        return pedidoRepository.getPedidoModelsByCliente_Nome(nome);
//    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
