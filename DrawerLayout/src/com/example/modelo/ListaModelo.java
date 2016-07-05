package com.example.modelo;

public class ListaModelo {
	
	private int idLayout;
	private int idImage;
	private int idTextView;
	private int idButton;
	private String descricao;
	
	public ListaModelo(int idLayout, int idImage, String descricao) {
		super();
		this.idLayout = idLayout;
		this.idImage = idImage;
		this.descricao = descricao;
	}
	
	public ListaModelo(int idLayout, String descricao) {
		super();
		this.idLayout = idLayout;
		this.descricao = descricao;
	}
	
	public ListaModelo(int idLayout, String descricao, int idTextView) {
		super();
		this.idLayout = idLayout;
		this.descricao = descricao;
		this.setIdTextView(idTextView);
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
	
	public int getIdButton() {
		return idButton;
	}

	public void setIdButton(int idButton) {
		this.idButton = idButton;
	}

	public int getIdTextView() {
		return idTextView;
	}

	public void setIdTextView(int idTextView) {
		this.idTextView = idTextView;
	}

	@Override
	public String toString() {
		return descricao;
	}
}

