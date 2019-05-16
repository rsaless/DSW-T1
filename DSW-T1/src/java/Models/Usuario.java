package Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Papel> roles;
    
    @Column(nullable = false, unique=true)
    private String email;
    
    @Column(nullable = false, unique=false)
    private String senha;
    
    @Column(nullable = false, unique=false)
    private Boolean ativo;

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public Boolean getAtivo() {return ativo;}
    public void setAtivo(Boolean ativo) {this.ativo = ativo;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public List<Papel> getRoles() {return roles;}
    public void setRoles(List<Papel> roles) {this.roles = roles;}
    
    @Override public String toString() { return email;}
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Usuario)) return false;
	Usuario other = (Usuario) obj;
	return other.email.equals(this.email);
    }
}
