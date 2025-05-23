package com.seuManoel.seuManoel.dto;

import java.util.List;

public record CaixaDTO(String tipoCaixa, List<ProdutoDTO> produtos) {
}