package Models;
//E-mail, senha, CNPJ, nome e cidade
public class Teatro {
    private String email;
    private String senha;
    private String cidade;
    private String nome;
    private Long cnpj;
    private Integer id;

    public Teatro(String email, String senha, String cidade, String nome, Long cnpj, Integer id) {
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.nome = nome;
        this.cnpj = cnpj;
        this.id = id;
    }
    public Teatro(String email, String senha, String cidade, String nome, Long cnpj) {
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.nome = nome;
        this.cnpj = cnpj;
    }
    public Teatro(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String getCidade() {
        return cidade;
    }
    public String getNome() {
        return nome;
    }
    public Long getCnpj() {
        return cnpj;
    }
    public Integer getId() {
        return id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    
}
