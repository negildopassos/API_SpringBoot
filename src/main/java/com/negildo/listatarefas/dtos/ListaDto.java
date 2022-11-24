package com.negildo.listatarefas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class ListaDto {


    @NotBlank
    private String descricao;


    private boolean status;
}


