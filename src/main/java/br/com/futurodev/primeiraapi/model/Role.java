package br.com.futurodev.primeiraapi.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRole;

    @Override
    public String getAuthority(){
        return this.nomeRole;
    }

    public Long getId(){
        return id;
    }

    public String getNomeRole(){
        return nomeRole;
    }


}
