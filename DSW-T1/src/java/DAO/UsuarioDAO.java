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
        
    /* C */ private final String INSERIR_ROLE = "INSERT INTO Papel(email, nome) values (?,?)";     
    /* R */ private final String LISTAR_ROLES = "SELECT p FROM Papel p";    
    /* U */ private final String ATUALIZAR_ROLE = "UPDATE Usuario SET nome=?, WHERE email=?"; 
    /* D */ private final String DELETAR_ROLE = "DELETE FROM Papel WHERE id=?";
    
    /* - */ private final String GET_USUARIO = "SELECT u FROM Usuario u where u.email = :email";
    /* - */ private final String ATIVA_DESATIVA = "UPDATE Usuario SET ativo=?, WHERE email=?"; 
       

    /* C */ @Override void inserir(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        
        tx.begin();
        em.persist(usuario);
        tx.commit();
        em.close();
    }
    /* R */ @Override List<Usuario> listar() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR_USUARIOS, Usuario.class); 
        List<Usuario> usuarios = q.getResultList();
        em.close();
        return usuarios;
    } 
    /* U */ @Override void atualizar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }
    /* D */ @Override void deletar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.getReference(Usuario.class, usuario.getId());
        tx.begin();
        em.remove(usuario);
        tx.commit();
    }
    /* - */ @Override Usuario get(int id) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }
    
    /* C */ public void inserir_role(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(papel);
        tx.commit();
        em.close();
    }  
    /* R */ public List<Papel> listar_roles(){
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR_ROLES, Papel.class); 
        List<Papel> papeis = q.getResultList();
        em.close();
        return papeis;
    }
    /* U */ public void atualizar_role(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(papel);
        tx.commit();
        em.close();
    }
    /* D */ void deletar(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        papel = em.getReference(Papel.class, papel.getId());
        tx.begin();
        em.remove(papel);
        tx.commit();
    }
    
}