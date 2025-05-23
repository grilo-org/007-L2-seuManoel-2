package com.seuManoel.seuManoel.model;

import com.seuManoel.seuManoel.dto.ProdutoDTO;

public class Caixa {
	private final String nome;
	private final double altura;
	private final double largura;
	private final double comprimento;

	public Caixa(String nome, double altura, double largura, double comprimento) {
		this.nome = nome;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
	}

	public boolean comportaProduto(ProdutoDTO produto) {
		return produto.altura() <= altura && produto.largura() <= largura && produto.comprimento() <= comprimento;
	}

	public boolean comporta(double volumeProduto) {
		return volumeProduto <= getVolume();
	}

	public double getVolume() {
		return altura * largura * comprimento;
	}

	public String getNome() {
		return nome;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}

	public double getComprimento() {
		return comprimento;
	}
}
