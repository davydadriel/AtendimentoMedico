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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karma
 */
@Entity
@Table(name="TB_Paciente")
@DiscriminatorValue(value="P")
@PrimaryKeyJoinColumn(name="ID_Pessoa", referencedColumnName = "ID")
public class Paciente extends Pessoa implements Serializable {
    
    @OneToMany(mappedBy = "paciente" ,fetch = FetchType.LAZY,
        cascade = CascadeType.ALL, orphanRemoval = true)
   // @JoinColumn(name = "ID_Prontuario", referencedColumnName = "ID")
    private List<Prontuario> prontuario;
    
    
    @Column(name = "TXT_MATRICULA", nullable = false)
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }




    @Override
    public String toString() {
        return "Paciente{" + "matricula=" + matricula + '}';
    }
    
    
}
