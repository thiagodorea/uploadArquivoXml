package com.tdorea.uploadarquivos.entities;

import com.tdorea.uploadarquivos.dtos.AgenteDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private Integer codigo;

    private Date data;

    @XmlElement(name = "regiao")
    @OneToMany
    private List<Regiao> regiao;

    public Agente(AgenteDto agenteDto) {
        this.codigo = agenteDto.getCodigo();
        this.data = agenteDto.getData();
        this.regiao = agenteDto.getRegiao().stream().map(Regiao::new).collect(Collectors.toList());
    }
}
