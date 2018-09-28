/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades.test;

import com.ifpe.entidades.Paciente;
import com.ifpe.entidades.Pessoa;
import com.ifpe.entidades.Prontuario;
import static com.ifpe.entidades.test.GenericTest.logger;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author karma
 */
public class PacienteCrudTest extends GenericTest {
    @Test
    public void persistirPaciente() {
        logger.info("Executando persistirPaciente()");
        Paciente paciente = criarPaciente();
        em.persist(paciente);
        em.flush();
        assertNotNull(paciente.getId());
        
    }
      
    @Test
    public void atualizarPaciente() {
        logger.info("Executando atualizarPaciente()");
        String nome = "Leia Organa";
        String rg = "O-6456";
        Long id = 4L;
        Paciente paciente = em.find(Paciente.class, id);
        paciente.setNome(nome);
        paciente.setRg(rg);
        em.flush();
    }
    
    @Test
    public void atualizarPacienteMerge() {
        logger.info("Executando atualizarPacienteMerge()");
        String nome = "pacienteMarge";
        String rg = "QQQPPP";
        Long id = 4L;
        Paciente paciente = em.find(Paciente.class, id);
        paciente.setNome(nome);
        paciente.setRg(rg);
        em.clear();
        em.merge(paciente);
    }   
    
    @Test
    public void removerPaciente() {
        logger.info("Executando removerPaciente()");
        Paciente paciente = em.find(Paciente.class, 4L);
        em.remove(paciente);
        Pessoa pessoa = em.find(Pessoa.class, 4L);
        assertNull(pessoa);
    }
      
    
   private Paciente criarPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome("Princesa Leia");
        paciente.setMatricula("48897987");
        paciente.setRg("AAX-8789");
        
        paciente.setProntuario(criarProntuario());
        return paciente;
    }
   
   private List<Prontuario> criarProntuario(){
       Prontuario prontuario = new Prontuario();
       prontuario.setDataEntrada("10-06-2018");
       prontuario.setDataSaida("11-06-2018");
       prontuario.setPrioridade("Alta");
       List<Prontuario> prontuarios = new ArrayList();
       prontuarios.add(prontuario);
       return prontuarios;
   }
}
