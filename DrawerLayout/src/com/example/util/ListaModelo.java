package com.example.util;

public class ListaModelo {
	
	private int idLayout;
	private int idImage;
	private String descricao;
	
	public ListaModelo(int idLayout, int idImage, String descricao) {
		super();
		this.idLayout = idLayout;
		this.idImage = idImage;
		this.descricao = descricao;
	}
	
	public ListaModelo(int idImage, String descricao) {
		super();
		this.idImage = idImage;
		this.descricao = descricao;
	}
	
	public int getIdLayout() {
		return idLayout;
	}
	public void setIdLayout(int idLayout) {
		this.idLayout = idLayout;
	}
	public int getIdImag() {
		return idImage;
	}
	public void setIdImag(int idImag) {
		this.idImage = idImag;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}

