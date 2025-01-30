package com.microservices.pedidos.notificacao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    private UUID id = UUID.randomUUID();
    private String nome;
    private Double valor;
}
