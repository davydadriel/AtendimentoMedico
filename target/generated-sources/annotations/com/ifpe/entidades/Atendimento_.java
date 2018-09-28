package com.ifpe.entidades;

import com.ifpe.entidades.Prontuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T20:30:24")
@StaticMetamodel(Atendimento.class)
public class Atendimento_ { 

    public static volatile SingularAttribute<Atendimento, Prontuario> prontuario;
    public static volatile SingularAttribute<Atendimento, String> descricaoAtendimento;
    public static volatile SingularAttribute<Atendimento, Long> id;
    public static volatile SingularAttribute<Atendimento, String> tipoAtendimento;

}