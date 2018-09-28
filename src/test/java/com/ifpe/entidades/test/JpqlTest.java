/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades.test;

import com.ifpe.entidades.Medico;
import com.ifpe.entidades.Paciente;
import com.ifpe.entidades.Pessoa;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author karma
 */
public class JpqlTest extends GenericTest {
    
    @Test
    public void consultaMedicoPorNome() {
        logger.info("Executando consultaMedicoPorNome()");
        TypedQuery<Medico> query = em.createQuery(
            "SELECT c FROM Medico c WHERE c.nome LIKE :nome",
            Medico.class);
        query.setParameter("nome", "Y%");
        List<Medico> medicos = query.getResultList();

        for (Medico medico : medicos) {
            assertTrue(medico.getNome().startsWith("Yoda"));
        }

        assertEquals(1, medicos.size());
    }  
    
    /*@Test
    public void consultaPessoasQueForemPacientes() {
        logger.info("Executando consultaPessoasQueForemPacientes()");
        TypedQuery<Pessoa> query = em.createQuery(
            "SELECT pes FROM Pessoa pes WHERE pes.nome LIKE :nome",
            Pessoa.class);
        query.setParameter("DISC_PESSOA", "P");
        List<Pessoa> pessoas = query.getResultList();

        for (Pessoa pessoa : pessoas) {
            assertTrue(pessoa.getNome().startsWith("Ichigo%"));
        }

        assertEquals(1, pessoas.size());
    }*/
    
    //@Test
    //public void prontuarioQuantidadeAtendimento() {
        //logger.info("Executando categoriaQuantidadeItensSQL()");
        //Query query;
        //query = em.createNamedQuery("Categoria.QuantidadeItensSQL");
        //query.setParameter(1, "Instrumentos Musicais");
        //Object[] resultado = (Object[]) query.getSingleResult();
        //assertEquals("Instrumentos Musicais", ((Categoria) resultado[0]).getNome());
        //assertEquals(5L, resultado[1]);
    //}
    
    
    @Test
    public void pacientePorNomeNamedQuery() {
        logger.info("Executando pacientePorNomeNamedQuery()");
        TypedQuery<Paciente> query = em.createNamedQuery("Paciente.PorNome", Paciente.class);
        query.setParameter("nome", "Ichi%");
        List<Paciente> pacientes = query.getResultList();

        for (Paciente paciente : pacientes) {
            assertTrue(paciente.getNome().startsWith("Ichigo Kurosaki"));
        }

        assertEquals(1, pacientes.size());
    }
    
    @Test
    public void pacienteSQL() {
        logger.info("Executando pacienteSQL()");
        Query query;
        query = em.createNativeQuery(
                "   SELECT ID, ID_Pessoa , TXT_NOME, TXT_RG, TXT_MATRICULA  "
                        + "FROM TB_Paciente tpa "
                        + "INNER JOIN TB_Pessoa tpe ON (tpe.ID = tpa.ID_Pessoa)"
                        + "WHERE ID_Pessoa is not null",
                Paciente.class);
        List<Paciente> pacientes = query.getResultList();
        assertEquals(6, pacientes.size());
    }
    
}
