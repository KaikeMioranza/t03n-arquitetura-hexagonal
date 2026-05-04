package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido;


import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoSqsEventAdapter {;

    private final PedidoServicePort pedidoServicePort;

    public PedidoSqsEventAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener(value = "${queue.order-events}")
    public void listen(PedidoSqsEventDTO dto) {
        System.out.println("Mensagem recebida da fila SQS: " + dto);

        PedidoBO pedidoBO = PedidoSqsEventDTOMapper.toBO(dto);

        pedidoServicePort.criarPedido(pedidoBO);

        System.out.println("Pedido persistido com sucesso via SQS!");
    }
};


