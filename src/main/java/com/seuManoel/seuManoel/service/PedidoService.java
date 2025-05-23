package com.seuManoel.seuManoel.service;

import com.seuManoel.seuManoel.dto.*;
import com.seuManoel.seuManoel.model.Caixa;
import com.seuManoel.seuManoel.exception.ProdutoIncompativelException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PedidoService {

	private final List<Caixa> caixasDisponiveis = List.of(new Caixa("Caixa 1", 30, 40, 80),
			new Caixa("Caixa 2", 80, 50, 40), new Caixa("Caixa 3", 50, 80, 60));

	public List<PedidoResponseDTO> processar(List<PedidoDTO> pedidos) {
		List<PedidoResponseDTO> respostas = new ArrayList<>();

		for (PedidoDTO pedido : pedidos) {
			List<CaixaResponseDTO> caixasUsadas = new ArrayList<>();
			List<ProdutoDTO> produtosRestantes = new ArrayList<>(pedido.produtos());

			// ✅ Validação: produto incompatível
			for (ProdutoDTO produto : produtosRestantes) {
				boolean cabeEmAlguma = caixasDisponiveis.stream()
						.anyMatch(caixa -> produto.altura() <= caixa.getAltura()
								&& produto.largura() <= caixa.getLargura()
								&& produto.comprimento() <= caixa.getComprimento());

				if (!cabeEmAlguma) {
					throw new ProdutoIncompativelException("Produto '" + produto.nome() + "' do pedido '"
							+ pedido.codigoPedido() + "' não cabe em nenhuma caixa disponível.");
				}
			}

			// ✅ Lógica de empacotamento (volume)
			for (Caixa caixa : caixasDisponiveis) {
				List<ProdutoDTO> produtosNaCaixa = new ArrayList<>();
				double volumeDisponivel = caixa.getVolume();

				Iterator<ProdutoDTO> iterator = produtosRestantes.iterator();
				while (iterator.hasNext()) {
					ProdutoDTO produto = iterator.next();
					double volumeProduto = produto.altura() * produto.largura() * produto.comprimento();

					if (produto.altura() <= caixa.getAltura() && produto.largura() <= caixa.getLargura()
							&& produto.comprimento() <= caixa.getComprimento() && volumeProduto <= volumeDisponivel) {

						produtosNaCaixa.add(produto);
						volumeDisponivel -= volumeProduto;
						iterator.remove();
					}
				}

				if (!produtosNaCaixa.isEmpty()) {
					caixasUsadas.add(new CaixaResponseDTO(caixa.getNome(), produtosNaCaixa));
				}

				if (produtosRestantes.isEmpty())
					break;
			}

			respostas.add(new PedidoResponseDTO(pedido.codigoPedido(), caixasUsadas));
		}

		return respostas;
	}
}
