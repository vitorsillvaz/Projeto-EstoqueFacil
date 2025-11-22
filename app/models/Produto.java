package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Produto extends Model {

	@Required
	@MinSize(value = 5, message = "O nome deve ter pelo menos 5 caracteres.")
	public String nomeProduto;

	@Required
	@Min(value = 1, message = "O valor do produto não pode ser negativo.")
	public Double preco;
	
	@Required
	@Min(value = 1, message = "O estoque deve ter no mínimo 1 unidade do produto.")
	public int quantidade;

	@Required
	@ManyToOne
	public Categoria categoria;

	@Enumerated(EnumType.STRING)
	public Status status;

	public Blob foto;
	public String photofileName;

	public Produto() {
		this.status = Status.ATIVO;
	}

	public Produto(String nomeProduto, double preco, int quantidade) {
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.status = Status.ATIVO;
	}
}
