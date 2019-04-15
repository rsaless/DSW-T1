package Models;
//E-mail, senha, url, nome e telefone
public class Usuario {
    private String email;
    private String senha;
    private Boolean ativo;
    private Integer id;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.ativo = true;
    }
    public Usuario(Integer id) {
        this.id = id;
    }
    public Usuario(String email, String senha, Boolean ativo, Integer id) {
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
