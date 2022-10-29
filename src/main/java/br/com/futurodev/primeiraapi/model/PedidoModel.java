package br.com.futurodev.primeiraapi.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido_venda")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dataHoraCadastro;
    private OffsetDateTime dataHoraAlteracao;

            @OneToOne
            @JoinColumn(name = "idCliente", referencedColumnName = "id")
            private ClienteModel cliente;
    @OneToOne
    @JoinColumn(name = "idFormaPagamento", referencedColumnName = "id")
    private FormaPagamentoModel formaPagamento;

//    @OneToMany(mappedBy = "pedido_venda",cascade = CascadeType.ALL)
//    private List<ItemPedidoModel> itens = new ArrayList<ItemPedidoModel>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(OffsetDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public OffsetDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(OffsetDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public FormaPagamentoModel getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoModel formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

//    public List<ItemPedidoModel> getItensPedidos() {
//        return itensPedidos;
//    }

//    public void setItensPedidos(List<ItemPedidoModel> itensPedidos) {
//        this.itensPedidos = itensPedidos;
//    }
}
