package com.microservices.pedidos.notificacao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.pedidos.notificacao.entity.enums.Status;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private Double valorTotal;
    private String emailNotificacao;
    private Status status = Status.EM_PROCESSAMENTO;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();


}
