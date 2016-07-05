package com.example.modelo;

import java.util.List;

public class ModeloGeral {

	private ListaModelo pai;
	private List<ListaModeloSub> filho;
	
	public ModeloGeral(ListaModelo pai, List<ListaModeloSub> filho) {
		super();
		this.pai = pai;
		this.filho = filho;
	}
	
	public ListaModelo getPai() {
		return pai;
	}
	public void setPai(ListaModelo pai) {
		this.pai = pai;
	}
	public List<ListaModeloSub> getFilho() {
		return filho;
	}
	public void setFilho(List<ListaModeloSub> filho) {
		this.filho = filho;
	}
}
