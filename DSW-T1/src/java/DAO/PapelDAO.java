
package DAO;

import Models.Papel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PapelDAO extends GenericDAO<Papel>{
    /* C */ private final String INSERIR_ROLE = "INSERT INTO Papel(email, nome) values (?,?)";     
    /* R */ private final String LISTAR_ROLES = "SELECT p FROM Papel p";    
    /* U */ private final String ATUALIZAR_ROLE = "UPDATE Usuario SET nome=?, WHERE email=?"; 
    /* D */ private final String DELETAR_ROLE = "DELETE FROM Papel WHERE id=?";
    /* - */ private final String GET_ROLE = "SELECT p FROM Papel p WHERE p.nome = :papel";
    
    /* C */ @Override public void inserir(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(papel);
        tx.commit();
        em.close();
    }
    /* R */ @Override public List<Papel> listar() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR_ROLES, Papel.class); 
        List<Papel> papeis = q.getResultList();
        em.close();
        return papeis;
    } 
    /* U */ @Override public void atualizar(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(papel);
        tx.commit();
        em.close();
    }
    /* D */ @Override public void deletar(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        papel = em.getReference(Papel.class, papel.getId());
        tx.begin();
        em.remove(papel);
        tx.commit();
    }
    /* - */ @Override public Papel get(int id) {
        EntityManager em = this.getEntityManager();
        Papel papel = em.find(Papel.class, id);
        em.close();
        return papel;
    }
    
    /* - */ public Papel get_role(String papel){
        EntityManager em = this.getEntityManager();
        TypedQuery<Papel> q = em.createQuery(GET_ROLE, Papel.class);
        q.setParameter("papel", papel);
        q.setMaxResults(1);
        List<Papel> list = q.getResultList();
        if (list == null || list.isEmpty()) {
            return new Papel();
        }
        return list.get(0); 
    }
}

