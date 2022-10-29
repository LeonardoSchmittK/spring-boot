package br.com.futurodev.primeiraapi.Repository;

import br.com.futurodev.primeiraapi.model.PedidoModel;
import br.com.futurodev.primeiraapi.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoModel,Long> {
    @Query(value="select u from PedidoModel u where u.id like %?1%")
    PedidoModel getPedidoModelById(Long id);

//    @Query(value="select u from PedidoModel u where PedidoModel.cliente.nome like %?1%")
//    List<PedidoModel> getPedidoModelsByCliente_Nome(String nome);

}
