/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author karma
 */
@Entity
@Table(name = "TB_Prontuario")
public class Prontuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "FK_Paciente", referencedColumnName = "ID_Pessoa")
    private Paciente paciente;
    
    @OneToMany(mappedBy = "prontuario",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
   // @JoinColumn(name = "FK_Prontuario", referencedColumnName = "ID")
    private List<Atendimento> atendimentos;
    
    @Column(name= "DT_ENTRADA", nullable = false)
    private String dataEntrada;
    
    @Column(name= "DT_SAIDA", nullable = false)
    private String dataSaida;
    
    @Column(name= "TXT_PRIORIDADE", nullable = false)
    private String prioridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // public Paciente getPaciente() {
    //    return paciente;
   // }

    //public void setPaciente(Paciente paciente) {
    //    this.paciente = paciente;
    //}

    
    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
    public void setAtendimento(Atendimento atendimento){
        this.atendimentos.add(atendimento);
    }

    @Override
    public String toString() {
        return "Prontuario{" + "id=" + id + ", atendimentos=" + atendimentos + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", prioridade=" + prioridade + '}';
    }



    

    
    
}
