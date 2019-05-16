package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {

    private final EntityManagerFactory emf;

    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory("DSWPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //Adicionar demais métodos necessários
    /* C */ abstract void inserir(T t);
    /* R */ abstract List<T> listar();
    /* U */ abstract void atualizar(T t);
    /* D */ abstract void deletar(T t);
    /* - */ abstract T get(int id);
    
    
         
    
}
