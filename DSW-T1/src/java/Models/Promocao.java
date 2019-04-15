package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Promocao {
    private String url;
    private String nome_peca;
    private Float preco;
    private Date data_hora;
    private Integer cnpj;
    private Integer id;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome_peca() {
        return nome_peca;
    }
    public void setNome_peca(String nome_peca) {
        this.nome_peca = nome_peca;
    }

    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }

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
    public Date getData_hora() {
        return data_hora;
    }
    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public Integer getCnpj() {
        return cnpj;
    }
    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
}
