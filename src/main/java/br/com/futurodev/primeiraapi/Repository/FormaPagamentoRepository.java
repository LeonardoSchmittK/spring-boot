package br.com.futurodev.primeiraapi.Repository;

import br.com.futurodev.primeiraapi.model.FormaPagamentoModel;
import org.springframework.data.repository.CrudRepository;

public interface FormaPagamentoRepository extends CrudRepository<FormaPagamentoModel, Long> {
}
