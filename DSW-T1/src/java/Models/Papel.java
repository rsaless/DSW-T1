package Models;
//E-mail, senha, url, nome e telefone
public class Papel {
    private String email;
    private String nome;
    private Integer id;

    public Papel(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public Papel(Integer id) {
        this.id = id;
    }

    public Papel(String email, String nome, Integer id) {
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
