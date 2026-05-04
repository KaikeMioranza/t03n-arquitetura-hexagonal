package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;

import java.util.ArrayList;
import java.util.List;

public class PedidoSqsEventDTOMapper {

    public static PedidoBO toBO(PedidoSqsEventDTO dto) {

        PessoaBO pessoa = new PessoaBO();
        pessoa.setId(dto.getCustomerId().intValue());

        List<PedidoProdutoBO> itens = new ArrayList<>();
        for (ItemSqsDTO itemDto : dto.getOrderItems()) {
            ProdutoBO produto = new ProdutoBO();
            produto.setId(itemDto.getSku().intValue());

            PedidoProdutoBO item = new PedidoProdutoBO();
            item.setProduto(produto);
            item.setQuantidade(itemDto.getAmount());

            itens.add(item);
        }

        PedidoBO pedidoBO = new PedidoBO();
        pedidoBO.setPessoa(pessoa);
        pedidoBO.setCep(dto.getZipCode());
        pedidoBO.setItens(itens);

        return pedidoBO;
    }
}