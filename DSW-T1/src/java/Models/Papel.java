package Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Cacheable(value = false)
public class Papel implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @ManyToMany(mappedBy = "papel")
    private List<Usuario> usuario;

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public List<Usuario> getUsuario() {return usuario;}
    public void setUsuario(List<Usuario> usuario) {this.usuario = usuario;}

}
