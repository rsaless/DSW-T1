package DAO;

import Models.Site;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class SiteDAO extends GenericDAO<Site>{
    //private final String INSERIR = "INSERT INTO Site(email, senha, url, nome, telefone) values (?,?,?,?,?)";                                                       
    // private final String ATUALIZAR = "UPDATE Site SET email=?, senha=?, url=?, nome=?, telefone=? WHERE id=?"; 
    // private final String DELETAR = "DELETE FROM Site WHERE id=?";   
    private final String LISTAR = "SELECT s FROM Site s"; 
    private final String GET = "SELECT s FROM Site s WHERE s.id = :id"; 
    private final String GET_EMAIL = "SELECT s FROM Site s WHERE s.email = :email";
    
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
        Query q = em.createQuery(LISTAR, Site.class); 
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
        q.setMaxResults(1);
        List<Site> list = q.getResultList();
        if (list == null || list.isEmpty()) {
            return new Site();
        }
        return list.get(0);   
    }
}
