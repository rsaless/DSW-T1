package Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Papel implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne 
    private Usuario usuario;
    
    @Column(nullable = false, unique=false)
    private String email;
    
    @Column(nullable = false, unique=false)
    private String nome;

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    
    @Override public String toString() { return nome;}
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Papel)) return false;
	Papel other = (Papel) obj;
	return other.nome.equals(this.nome);
    }

}
