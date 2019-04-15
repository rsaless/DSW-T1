package Models;
//E-mail, senha, url, nome e telefone
public class Site {
    private String email;
    private String senha;
    private String url;
    private String nome;
    private Integer telefone;
    private Integer id;

    public Site(String email, String senha, String url, String nome, Integer telefone, Integer id) {
        this.email = email;
        this.senha = senha;
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
    }
    public Site(String email, String senha, String url, String nome, Integer telefone) {
        this.email = email;
        this.senha = senha;
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }
    public Site(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String getUrl() {
        return url;
    }
    public String getNome() {
        return nome;
    }
    public Integer getTelefone() {
        return telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
