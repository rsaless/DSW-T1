/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Rafael
 */
public class UsuarioRole extends Usuario {
    private String papel;

    public UsuarioRole(String email, String senha, String papel, Boolean ativo, Integer id) {
        super(email, senha, ativo, id);
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
    
}
