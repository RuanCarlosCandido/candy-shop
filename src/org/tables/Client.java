package org.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Client {
	@Id
	private int ID_cliente;
	private String nome;
	private String endereco;
	private String telefone;

	@Override
	public String toString() {
		return "Client [ID_cliente=" + ID_cliente + ", " + (nome != null ? "nome=" + nome + ", " : "")
				+ (endereco != null ? "endereco=" + endereco + ", " : "")
				+ (telefone != null ? "telefone=" + telefone : "") + "]";
	}

	public int getID_cliente() {
		return ID_cliente;
	}

	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
