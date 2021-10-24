package org.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Sale {

	@Id 
	private int ID_venda;
	private String produto;
	private String data;
	private String cliente;

	public int getID_venda() {
		return ID_venda;
	}

	public void setID_venda(int iD_venda) {
		ID_venda = iD_venda;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}