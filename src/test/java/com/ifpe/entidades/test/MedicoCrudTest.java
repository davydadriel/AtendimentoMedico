/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades.test;

import com.ifpe.entidades.Medico;
import com.ifpe.entidades.Pessoa;
import static com.ifpe.entidades.test.GenericTest.logger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author karma
 */
public class MedicoCrudTest extends GenericTest{
    
    @Test
    public void persistirMedico() {
        logger.info("Executando persistirMedico()");
        Medico medico = criarMedico();
        em.persist(medico);
        em.flush();
        assertNotNull(medico.getId());
        
    }
       
    @Test
    public void atualizarMedico() {
        logger.info("Executando atualizarMedico()");
        String nome = "Aquele teste legal";
        String rg = "(81) 990901010";
        Long id = 1L;
        Medico medico = em.find(Medico.class, id);
        medico.setNome(nome);
        medico.setRg(rg);
        em.flush();
    }
    
    @Test
    public void atualizarMedicoMerge() {
        logger.info("Executando atualizarMedicoMarge()");
        String nome = "bbb";
        String rg = "(81) 990901010";
        Long id = 1L;
        Medico medico = em.find(Medico.class, id);
        medico.setNome(nome);
        medico.setRg(rg);
        em.clear();
        em.merge(medico);
    }    
    
    @Test
    public void removerMedico() {
        logger.info("Executando removerMedico()");
        Medico medico = em.find(Medico.class, 9L);
        em.remove(medico);
        Pessoa pessoa = em.find(Pessoa.class, 9L);
        assertNull(pessoa);
    }
      
    
   private Medico criarMedico() {
        Medico medico = new Medico();
        medico.setCrm("CRM do médico J");
        medico.setNome("ccc");
        medico.setRg("Rg do médico J");
        medico.setSenha("Senha do médico J");
        return medico;
    }
    
}
