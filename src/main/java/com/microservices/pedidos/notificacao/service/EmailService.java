package com.microservices.pedidos.notificacao.service;

import com.microservices.pedidos.notificacao.entity.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void enviarEmail(Pedido pedido){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("pedidos-api@company.com"); //define o email que está enviando
        simpleMailMessage.setTo(pedido.getEmailNotificacao()); //destinatário
        simpleMailMessage.setSubject("Pedido de Compra"); //assunto
        simpleMailMessage.setText(this.gerarMensagem(pedido)); // define a mensagem
        mailSender.send(simpleMailMessage);
    }

    private String gerarMensagem(Pedido pedido) {
        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valorTotal = String.valueOf(pedido.getValorTotal());
        String status = pedido.getStatus().name();
        return String.format(
                "Olá %s, seu pedido de nº %s, no valor de %s, foi realizado com sucesso. \n" +
                "Status: %s.", cliente, pedidoId, valorTotal, status);
    }
}
