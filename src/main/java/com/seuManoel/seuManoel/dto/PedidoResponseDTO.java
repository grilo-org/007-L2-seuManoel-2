package com.seuManoel.seuManoel.dto;

import java.util.List;

public record PedidoResponseDTO(String codigoPedido, List<CaixaResponseDTO> caixas) {
}
