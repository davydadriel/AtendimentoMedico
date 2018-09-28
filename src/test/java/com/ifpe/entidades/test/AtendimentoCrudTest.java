/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades.test;

import com.ifpe.entidades.Atendimento;
import com.ifpe.entidades.Prontuario;
import static com.ifpe.entidades.test.GenericTest.logger;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author karma
 */
public class AtendimentoCrudTest extends GenericTest {
    @Test
    public void persistirAtendimento() {
        logger.info("Executando persistirAtendimento()");
        Prontuario prontuario = em.find(Prontuario.class, 2L);
        Atendimento atendimento = criarAtendimento();
        atendimento.setProntuario(prontuario);
        em.persist(atendimento);
        em.flush();
        assertNotNull(atendimento.getId());
        
    }
      
    @Test
    public void atualizarAtendimento() {
        logger.info("Executando atualizarAtendimento()");
        String tipo = "CIRURGICO";
        Long id = 1L;
        Atendimento atendimento = em.find(Atendimento.class, id);
        logger.info("descrição no atualizar: "+atendimento.getDescricaoAtendimento());
        atendimento.setTipoAtendimento(tipo);
        em.flush();
        
    }
    
    @Test
    public void atualizarAtendimentoMarge() {
        logger.info("Executando atualizarAtendimentoMarge()");
        Long id = 2L;
        Atendimento atendimento = em.find(Atendimento.class, id);
        atendimento.setDescricaoAtendimento("Remoção de gordura");
        em.clear();
        em.merge(atendimento);
    }   
    
    @Test
    public void removerAtendimento() {
        logger.info("Executando removerAtendimento()");
        Atendimento atendimento = em.find(Atendimento.class, 1L);
        em.remove(atendimento);
    }
      
    
   private Atendimento criarAtendimento() {
        Atendimento atendimento = new Atendimento();
        atendimento.setDescricaoAtendimento("Atendimento na classe de Test.");
        atendimento.setTipoAtendimento("MEDICAÇÃO");
        return atendimento;
    }
   

}
