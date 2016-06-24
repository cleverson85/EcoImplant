package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.example.drawerlayout.R;

public class ListaMenu {
	
	public static List<ListaModelo> loadItemMenu(){
		
		List<ListaModelo> lista = new ArrayList<ListaModelo>();
		
		lista.add(new ListaModelo(R.layout.activity_main, R.drawable.ic_location, "Home"));
		lista.add(new ListaModelo(R.layout.fragment_consc, R.drawable.ic_location, "Conscientização"));
		lista.add(new ListaModelo(R.layout.fragment_descarte, R.drawable.ic_carta, "Descarte"));
		lista.add(new ListaModelo(R.layout.fragment_locais, R.drawable.ic_location, "Locais"));
		lista.add(new ListaModelo(R.layout.fragment_nreciclavel, R.drawable.ic_location, "Não Recicláveis"));
		lista.add(new ListaModelo(R.layout.fragment_jogos, R.drawable.ic_location, "Jogos"));
		lista.add(new ListaModelo(R.layout.fragment_reuso, R.drawable.ic_location, "Reutilizar"));
		lista.add(new ListaModelo(R.layout.fragment_tecnica, R.drawable.ic_location, "Ass. Técnica"));
		lista.add(new ListaModelo(R.layout.fragment_sugest, R.drawable.ic_location, "Sugestões"));
				
		return lista;
	}
}
