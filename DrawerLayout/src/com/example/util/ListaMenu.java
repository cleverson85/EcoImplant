package com.example.util;

import java.util.TreeMap;

import com.example.drawerlayout.R;

public class ListaMenu {

	public static TreeMap loadItemMenu(){
		
		TreeMap<Integer, String> lista = new TreeMap<Integer, String>();
		lista.put(R.layout.activity_main, "Home");
		lista.put(R.layout.fragment_consc, "Conscientização");
		lista.put(R.layout.fragment_descarte, "Descarte");
		lista.put(R.layout.fragment_locais, "Locais");
		lista.put(R.layout.fragment_nreciclavel, "Não Recicláveis");
		lista.put(R.layout.fragment_jogos, "Jogos");
		lista.put(R.layout.fragment_reuso, "Reutilizar");
		lista.put(R.layout.fragment_tecnica, "Ass. Técnica");
		lista.put(R.layout.fragment_sugest, "Sugestões");
		
		return lista;
	}
}
