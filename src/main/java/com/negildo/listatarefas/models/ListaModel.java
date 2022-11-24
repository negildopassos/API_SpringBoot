package com.negildo.listatarefas.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LISTA_TAREFAS")
@Getter
@Setter
public class ListaModel implements Serializable {
    private static final long serialVersioLONG= 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,  length = 140)
    private String descricao;

    @Column
    private boolean status;


}
