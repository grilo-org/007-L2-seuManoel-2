package com.seuManoel.seuManoel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seuManoel.seuManoel.dto.PedidoDTO;
import com.seuManoel.seuManoel.dto.PedidoResponseDTO;
import com.seuManoel.seuManoel.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Operações relacionadas a pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@PostMapping
	@Operation(summary = "Processa pedidos e organiza os produtos em caixas de papelão")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Pedido processado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Um ou mais produtos não cabem em nenhuma caixa") })
	public ResponseEntity<List<PedidoResponseDTO>> processarPedidos(@RequestBody List<PedidoDTO> pedidos) {
		return ResponseEntity.ok(pedidoService.processar(pedidos));
	}
}
