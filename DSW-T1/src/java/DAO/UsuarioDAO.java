package DAO;

import Models.Papel;
import Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDAO extends GenericDAO<Usuario>{
    /* C */ private final String INSERIR_USUARIO = "INSERT INTO Usuario(email, senha, ativo) values (?,?,1)";   
    /* R */ private final String LISTAR_USUARIOS = "SELECT u FROM Usuario u";
    /* U */ private final String ATUALIZAR_USUARIO = "UPDATE Usuario SET email=?, senha=? WHERE id=?"; 
    /* D */ private final String DELETAR_USUARIO = "DELETE FROM Usuario WHERE id=?";

    /* - */ private final String GET_USUARIO = "SELECT u FROM Usuario u where u.email = :email";
    /* - */ private final String ATIVA_DESATIVA = "UPDATE Usuario SET ativo=?, WHERE email=?"; 
       
    /* C */ @Override public void inserir(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // usuario.setSenha(encoder.encode(usuario.getSenha()));
        
        tx.begin();
        em.persist(usuario);
        tx.commit();
        em.close();
    }
    /* R */ @Override public List<Usuario> listar() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR_USUARIOS, Usuario.class); 
        List<Usuario> usuarios = q.getResultList();
        em.close();
        return usuarios;
    } 
    /* U */ @Override public void atualizar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // usuario.setSenha(encoder.encode(usuario.getSenha()));
        
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }
    /* D */ @Override public void deletar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.getReference(Usuario.class, usuario.getId());
        tx.begin();
        em.remove(usuario);
        tx.commit();
    }
    /* - */ @Override public Usuario get(int id) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }
}