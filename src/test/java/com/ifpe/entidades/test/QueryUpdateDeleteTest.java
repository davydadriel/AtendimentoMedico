/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades.test;

import com.ifpe.entidades.Atendimento;
import com.ifpe.entidades.Paciente;
import com.ifpe.entidades.Prontuario;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static com.ifpe.entidades.test.GenericTest.logger;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

/**
 *
 * @author karma
 */
public class QueryUpdateDeleteTest extends GenericTest{
   

    @Test
    public void queryUpdate() {
        logger.info("Executando queryUpdate()");
        Long id = 2L;
        Query update = em.createQuery("UPDATE Prontuario AS v SET v.prioridade = ?1 WHERE v.id = ?2");
        update.setParameter(1, "MUDEI");
        update.setParameter(2, id);
        update.executeUpdate();
        String jpql = "SELECT v FROM Prontuario v WHERE v.id = :id";
        TypedQuery<Prontuario> query = em.createQuery(jpql, Prontuario.class);
        query.setParameter("id", id);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        Prontuario prontuario = query.getSingleResult();
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String prioridade = "MUDEI";
        assertEquals(prioridade, prontuario.getPrioridade());
        logger.info(prontuario.getPrioridade().toString());
    }
    
    

    @Test(expected = NoResultException.class)
    public void queryDelete() {
        logger.info("Executando queryDelete()");
        Long id = (long) 2;
        Query delete = em.createQuery("DELETE FROM Atendimento AS o WHERE o.id = ?1");
        delete.setParameter(1, id);
        delete.executeUpdate();
        String jpql = "SELECT o FROM Atendimento o WHERE o.id =?1";
        TypedQuery<Atendimento> query = em.createQuery(jpql, Atendimento.class);
        query.setParameter(1, id);
        query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        query.getSingleResult();
    }
    
    
  
    
    
}
