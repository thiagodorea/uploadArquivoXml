package com.tdorea.agentes.entities;

import com.tdorea.agentes.dto.AgenteDto;
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
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="agente")
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue
    private UUID id;

    private Integer codigo;

    private Date data;

    @XmlElement(name = "regiao")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Regiao> regiao;

    public Agente(AgenteDto agenteDto) {
        this.codigo = agenteDto.getCodigo();
        this.data = agenteDto.getData();
        this.regiao = agenteDto.getRegiao().stream().map(Regiao::new).collect(Collectors.toList());
    }
}
