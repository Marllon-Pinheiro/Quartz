package br.com.quartzapp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ativo {

	private Integer id;
	private String nome;
	private BigDecimal preco;
	private LocalDateTime dataRegistro;

	public Ativo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Override
	public String toString() {
		return "Nome do ativo: " + this.nome + ", Preço do ativo: " + this.preco + ", Data do registro: "
				+ this.dataRegistro + "\n";
	}

}
