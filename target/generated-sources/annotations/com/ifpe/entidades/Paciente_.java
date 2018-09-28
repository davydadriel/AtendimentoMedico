package com.ifpe.entidades;

import com.ifpe.entidades.Prontuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T20:30:24")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Pessoa_ {

    public static volatile ListAttribute<Paciente, Prontuario> prontuario;
    public static volatile SingularAttribute<Paciente, String> matricula;

}