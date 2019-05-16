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
public class Teatro implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(mappedBy = "teatro", fetch = FetchType.LAZY)
    private List<Promocao> promocoes;
    
    @Column(nullable = false, unique=true)
    private String email;
    
    @Column(nullable = false, unique=false)
    private String senha;
    
    @Column(nullable = false, unique=false)
    private String cidade;
    
    @Column(nullable = false, unique=false)
    private String nome;
    
    @Column(nullable = false, unique=false)
    private String cnpj;
    
    public String getEmail() {return email;}
    public String getSenha() {return senha;}
    public String getCidade() {return cidade;}
    public String getNome() {return nome;}
    public String getCnpj() {return cnpj;}
    public Integer getId() {return id;}
    public List<Promocao> getPromocoes() {return promocoes;}

    public void setSenha(String senha) {this.senha = senha;}
    public void setEmail(String email) {this.email = email;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public void setId(Integer id) {this.id = id;}
    public void setPromocoes(List<Promocao> promocoes) {this.promocoes = promocoes;}
    
    @Override public String toString() { return nome;}
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Teatro)) return false;
	Teatro other = (Teatro) obj;
	return other.nome.equals(this.nome);
    }
}
