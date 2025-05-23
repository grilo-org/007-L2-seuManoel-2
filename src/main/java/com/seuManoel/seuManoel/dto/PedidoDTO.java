package com.seuManoel.seuManoel.dto;

import java.util.List;

public record PedidoDTO(String codigoPedido, List<ProdutoDTO> produtos) {}
