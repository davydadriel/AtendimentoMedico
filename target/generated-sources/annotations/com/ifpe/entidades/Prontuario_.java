package com.ifpe.entidades;

import com.ifpe.entidades.Atendimento;
import com.ifpe.entidades.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T20:30:24")
@StaticMetamodel(Prontuario.class)
public class Prontuario_ { 

    public static volatile SingularAttribute<Prontuario, String> prioridade;
    public static volatile SingularAttribute<Prontuario, String> dataEntrada;
    public static volatile SingularAttribute<Prontuario, Paciente> paciente;
    public static volatile ListAttribute<Prontuario, Atendimento> atendimentos;
    public static volatile SingularAttribute<Prontuario, Long> id;
    public static volatile SingularAttribute<Prontuario, String> dataSaida;

}