package com.microservices.pedidos.notificacao.listener;

import com.microservices.pedidos.notificacao.entity.Pedido;
import com.microservices.pedidos.notificacao.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    private final EmailService emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {
        emailService.enviarEmail(pedido);
        logger.info("Notificação gerada: {}", pedido);
    }
}
