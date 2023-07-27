package com.brunoandreotti.deliveryapi.domain.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_estado")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(nullable = false)
  private String nome;

  @JsonIgnore
  @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Cidade> cidades;
}
