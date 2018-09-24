/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karma
 */
@Entity
@Table(name="TB_Medico")
@DiscriminatorValue(value="M")
@PrimaryKeyJoinColumn(name="ID_Pessoa", referencedColumnName = "ID")
public class Medico extends Pessoa implements Serializable {
    @Column(name = "TXT_CRM", nullable = false)
    private String crm;
    
    @Column(name = "TXT_SENHA", nullable = false)
    private String senha;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", senha=" + senha + '}';
    }
    
    
    
}
