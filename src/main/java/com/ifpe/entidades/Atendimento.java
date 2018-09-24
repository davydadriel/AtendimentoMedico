/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author karma
 */
@Entity
@Table(name = "TB_Atendimento")
public class Atendimento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_Prontuario", referencedColumnName = "ID")
    private Prontuario prontuario;
    
    //private Date dataHoraEntrada;
    
    //private Date dataHoraSaida;
    
    @Column(name = "TXT_TIPO_ATENDIMENTO", nullable = false)
    private String tipoAtendimento;
    
    @Column(name = "TXT_DESCRICAO_ATENDIMENTO", nullable = false)
    private String descricaoAtendimento;
    
    //public Atendimento(){
      //  setData(new Date());
    //}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", prontuario=" + prontuario + ", tipoAtendimento=" + tipoAtendimento + ", descricaoAtendimento=" + descricaoAtendimento + '}';
    }


    
    
}
