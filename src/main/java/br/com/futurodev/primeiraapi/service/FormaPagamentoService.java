package br.com.futurodev.primeiraapi.service;

import br.com.futurodev.primeiraapi.Repository.FormaPagamentoRepository;
import br.com.futurodev.primeiraapi.Repository.PedidoRepository;
import br.com.futurodev.primeiraapi.model.FormaPagamentoModel;
import br.com.futurodev.primeiraapi.model.PedidoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService implements UserDetailsService {
    @Autowired
    private static FormaPagamentoRepository formaPagamentoRepository;

    public static FormaPagamentoModel salvar(FormaPagamentoModel formaPagamento){
        return formaPagamentoRepository.save(formaPagamento);
    }
    public void delete(Long idUsuario){
        formaPagamentoRepository.deleteById(idUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
