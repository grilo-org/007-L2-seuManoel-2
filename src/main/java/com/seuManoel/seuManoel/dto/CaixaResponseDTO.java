package com.seuManoel.seuManoel.dto;

import java.util.List;

public record CaixaResponseDTO(String tipoCaixa, List<ProdutoDTO> produtos) {
}
