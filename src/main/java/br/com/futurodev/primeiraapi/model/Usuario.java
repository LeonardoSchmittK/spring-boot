package br.com.futurodev.primeiraapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {

    @Id
    @SequenceGenerator(name="seq_usuario",sequenceName = "seq_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String senha;

    @Column(unique = true)
    private String login;

    private String nome;




    @CreationTimestamp
    @Column(columnDefinition = "timestamp(0) with time zone DEFAULT timezone('utc'::text, CURRENT_TIMESTAMP(0))",updatable = false)
    private OffsetDateTime dataCadastro;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp(0) with time zone DEFAULT timezone('utc'::text, CURRENT_TIMESTAMP(0))")
    private OffsetDateTime dataAtualizacao;


    @OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<Telefone> telefones = new ArrayList<Telefone>();


    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    @OneToMany
    @JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(
                    columnNames = {"usuario_id", "role_id"}, name = "unique_role_usuario"),
                    joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario",
                            foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
                    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role", updatable = false,
                            foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Role> roles;


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario that = (Usuario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
