package Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, unique=true)
    private String email;
    
    @Column(nullable = false, unique=false)
    private String senha;
    
    @Column(nullable = false, unique=false)
    private Boolean ativo;
    
    @ManyToMany
    private List<Papel> papel;

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public Boolean getAtivo() {return ativo;}
    public void setAtivo(Boolean ativo) {this.ativo = ativo;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    
    public List<Papel> getPapel() {return papel;}
    public void setPapel(List<Papel> papel) {this.papel = papel;}
    
}
