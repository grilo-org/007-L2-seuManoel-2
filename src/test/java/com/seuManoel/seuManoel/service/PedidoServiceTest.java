package com.seuManoel.seuManoel.service;

import com.seuManoel.seuManoel.dto.*;
import com.seuManoel.seuManoel.exception.ProdutoIncompativelException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoServiceTest {

	private final PedidoService pedidoService = new PedidoService();

	@Test
	public void deveEmpacotarProdutosEmUmaCaixa() {
		ProdutoDTO controle = new ProdutoDTO("Controle", 10, 10, 10);
		ProdutoDTO console = new ProdutoDTO("Console", 30, 30, 20);
		ProdutoDTO fone = new ProdutoDTO("Fone", 5, 5, 5);

		PedidoDTO pedido = new PedidoDTO("001", List.of(controle, console, fone));
		List<PedidoResponseDTO> resposta = pedidoService.processar(List.of(pedido));

		assertEquals(1, resposta.size());
		PedidoResponseDTO pedidoResult = resposta.get(0);
		assertEquals("001", pedidoResult.codigoPedido());
		assertFalse(pedidoResult.caixas().isEmpty());

		int totalProdutos = pedidoResult.caixas().stream().mapToInt(c -> c.produtos().size()).sum();

		assertEquals(3, totalProdutos);
	}

	@Test
	public void deveLancarExcecaoSeProdutoNaoCabeEmNenhumaCaixa() {
		ProdutoDTO gigante = new ProdutoDTO("TV 100 polegadas", 200, 200, 200);
		PedidoDTO pedido = new PedidoDTO("999", List.of(gigante));

		ProdutoIncompativelException ex = assertThrows(ProdutoIncompativelException.class,
				() -> pedidoService.processar(List.of(pedido)));

		assertTrue(ex.getMessage().contains("não cabe em nenhuma caixa"));
	}
}
