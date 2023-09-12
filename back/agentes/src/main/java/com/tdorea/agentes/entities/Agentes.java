package com.tdorea.agentes.entities;

import com.tdorea.agentes.dto.AgentesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@XmlRootElement(name="agentes")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="agentes")
public class Agentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;

    @XmlElement(name = "agente")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Agente> agente;

    public Agentes(AgentesDto agentesDto) {
        this.id = agentesDto.getId();
        this.agente = agentesDto.getAgente();
    }
}
