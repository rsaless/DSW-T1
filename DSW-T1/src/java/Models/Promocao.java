package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Promocao {
    private String url;
    private String nome_peca;
    private Float preco;
    private LocalDate dia;    
    private LocalTime hora;
    private Integer cnpj;
    private Integer id;

    public Promocao(String url, String nome_peca, Float preco, LocalDate dia, LocalTime hora, Integer cnpj, Integer id) {
        this.url = url;
        this.nome_peca = nome_peca;
        this.preco = preco;
        this.dia = dia;
        this.hora = hora;
        this.cnpj = cnpj;
        this.id = id;
    }
    public Promocao(String url, String nome_peca, Float preco, LocalDate dia, LocalTime hora, Integer cnpj) {
        this.url = url;
        this.nome_peca = nome_peca;
        this.preco = preco;
        this.dia = dia;
        this.hora = hora;
        this.cnpj = cnpj;
    }
    public Promocao(Integer id) {
        this.id = id;
    }

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

    public LocalDate getDia() {
        return dia;
    }
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
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