package br.com.futurodev.primeiraapi.service;

import br.com.futurodev.primeiraapi.Repository.ProdutoRepository;
import br.com.futurodev.primeiraapi.model.PedidoModel;
import br.com.futurodev.primeiraapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements UserDetailsService {

    @Autowired
private    ProdutoRepository produtoRepository;


    public Produto salvar(Produto prod){
        return produtoRepository.save(prod);
    }

    public void delete(Long idUsuario){
        produtoRepository.deleteById(idUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
