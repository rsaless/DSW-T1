package DAO;

import Models.Site;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class SiteDAO extends GenericDAO<Site>{
    /* C */ private final String INSERIR = "INSERT INTO Site(email, senha, url, nome, telefone) values (?,?,?,?,?)";   
    /* R */ private final String LISTAR = "SELECT * FROM Site";                                                        
    /* U */ private final String ATUALIZAR = "UPDATE Site SET email=?, senha=?, url=?, nome=?, telefone=? WHERE id=?"; 
    /* D */ private final String DELETAR = "DELETE FROM Site WHERE id=?";
    /* - */ private final String GET = "SELECT * FROM Site where id=?"; 
    /* - */ private final String GET_EMAIL = "SELECT * FROM Site where email = :email";
    
    /* C */ @Override public void inserir(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site);
        tx.commit();
        em.close();
    }
    /* R */ @Override public List<Site> listar(){
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery(LISTAR, Site.class); // ORIGINAL: select l from Site l
        List<Site> sites = q.getResultList();
        em.close();
        return sites; 
    }   
    /* U */ @Override public void atualizar(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site);
        tx.commit();
        em.close();
    }
    /* D */ @Override public void deletar(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site = em.getReference(Site.class, site.getId());
        tx.begin();
        em.remove(site);
        tx.commit();
    }
    /* - */ @Override public Site get(int id){     
        EntityManager em = this.getEntityManager();
        Site site = em.find(Site.class, id);
        em.close();
        return site;
    }
   
    /* - */ public Site get_email(String email){
        EntityManager em = this.getEntityManager();
        TypedQuery<Site> q = em.createQuery(GET_EMAIL, Site.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }

}
