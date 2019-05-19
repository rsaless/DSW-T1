package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/** 
 * O mesmo teatro não pode apresentar duas promoções para mesma data e hora
 * Cada coluna possui unique = false
 * Mas o conjunto formado pelos 3 atributos deve ser único
 */
@Entity 
public class Promocao implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne 
    private Site site;
    
    @ManyToOne 
    private Teatro teatro;
    
    @Column(nullable = false, unique=false)
    private String url;
    
    @Column(nullable = false, unique=false)
    private String nome_peca;
    
    @Column(nullable = false, unique=false)
    private Float preco;
    
    @Column(nullable = false, unique=false)
    private LocalDate dia;    
    
    @Column(nullable = false, unique=false)
    private LocalTime hora;
    
    @Column(nullable = false, unique=false)
    private String cnpj;

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    public String getNome_peca() {return nome_peca;}
    public void setNome_peca(String nome_peca) {this.nome_peca = nome_peca;}

    public Float getPreco() {return preco;}
    public void setPreco(Float preco) {this.preco = preco;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public LocalDate getDia() {return dia;}
    public void setDia(LocalDate dia) {this.dia = dia;}

    public LocalTime getHora() {return hora;}
    public void setHora(LocalTime hora) {this.hora = hora;}

    public Site getSite() {return site;}
    public void setSite(Site site) {this.site = site;}

    public Teatro getTeatro() {return teatro;}
    public void setTeatro(Teatro teatro) {this.teatro = teatro;}
    
    @Override public String toString() { return nome_peca;}
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Promocao)) return false;
	Promocao other = (Promocao) obj;
	return other.nome_peca.equals(this.nome_peca);
    }
}

/*
Maneira antiga (não apagar)

    public String getData(){
        // Retorna apenas a data (dia/mes/ano)
        DateFormat data_format = new SimpleDateFormat("dd/MM/yyyy");
	return data_format.format(this.getData_hora());
    }
    public String getHora(){
        // Retorna apenas a hora (hh:mm:ss)
        SimpleDateFormat hora_format = new SimpleDateFormat("HH:mm:ss");
        return hora_format.format(this.getData_hora());
    }
*/