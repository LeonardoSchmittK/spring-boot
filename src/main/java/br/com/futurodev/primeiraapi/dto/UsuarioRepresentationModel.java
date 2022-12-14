package br.com.futurodev.primeiraapi.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepresentationModel {
    private Long id;
    private String nome;
    private String login;

    private OffsetDateTime dataAtualizacao;
    private OffsetDateTime dataCadastro;

    private List<TelefoneRepresentationModel> telefones = new ArrayList<TelefoneRepresentationModel>();


    public List<TelefoneRepresentationModel> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneRepresentationModel> telefones) {
        this.telefones = telefones;
    }


    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
