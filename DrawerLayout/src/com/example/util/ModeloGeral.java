package com.example.util;

public class ModeloGeral {

	private ListaModelo pai;
	private ListaModeloSub filho;
	
	public ListaModelo getPai() {
		return pai;
	}
	public void setPai(ListaModelo pai) {
		this.pai = pai;
	}
	public ListaModeloSub getFilho() {
		return filho;
	}
	public void setFilho(ListaModeloSub filho) {
		this.filho = filho;
	}
}
